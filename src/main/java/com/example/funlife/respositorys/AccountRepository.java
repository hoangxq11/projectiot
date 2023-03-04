package com.example.funlife.respositorys;

import com.example.funlife.models.users.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
