package com.example.funlife.services;

import com.example.funlife.models.users.Account;
import com.example.funlife.models.users.Authority;
import com.example.funlife.payload.response.AccountDTO;
import com.example.funlife.respositorys.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final AccountRepository accountRepository;

    public List<AccountDTO> getAllAccount(){
        return accountRepository.findAll().stream().map(e -> {
            return AccountDTO.builder()
                    .email(e.getEmail())
                    .id(e.getId())
                    .username(e.getUsername())
                    .role((new ArrayList<Authority>(e.getAuthorities())).get(0).getName().toString())
                    .build();
        }).collect(Collectors.toList());
    }
}
