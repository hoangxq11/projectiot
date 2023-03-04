package com.example.funlife.controllers.auth;

import com.example.funlife.models.users.AuthoritiesConstants;
import com.example.funlife.models.users.Authority;
import com.example.funlife.models.users.Account;
import com.example.funlife.payload.request.LoginRequest;
import com.example.funlife.payload.request.SignupRequest;
import com.example.funlife.payload.response.JwtResponse;
import com.example.funlife.payload.response.MessageResponse;
import com.example.funlife.respositorys.RoleRepository;
import com.example.funlife.respositorys.AccountRepository;
import com.example.funlife.security.jwt.JwtUtils;
import com.example.funlife.security.services.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Account account = new Account(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Authority> authorities = new HashSet<>();

        if (strRoles == null) {
            Authority userAuthority = roleRepository.findByName(AuthoritiesConstants.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            authorities.add(userAuthority);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Authority adminAuthority = roleRepository.findByName(AuthoritiesConstants.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        authorities.add(adminAuthority);

                        break;
                    default:
                        Authority userAuthority = roleRepository.findByName(AuthoritiesConstants.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        authorities.add(userAuthority);
                }
            });
        }

        account.setAuthorities(authorities);
        accountRepository.save(account);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
