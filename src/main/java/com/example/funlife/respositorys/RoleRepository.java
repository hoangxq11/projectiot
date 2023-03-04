package com.example.funlife.respositorys;

import com.example.funlife.models.users.AuthoritiesConstants;
import com.example.funlife.models.users.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Authority, String> {
  Optional<Authority> findByName(AuthoritiesConstants name);
}
