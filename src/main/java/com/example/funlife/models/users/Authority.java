package com.example.funlife.models.users;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
public class Authority {
    @Id
    private String id;

    private AuthoritiesConstants name;
}