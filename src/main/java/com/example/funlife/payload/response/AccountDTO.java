package com.example.funlife.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {
    private String id;
    private String username;
    private String email;
    private String role;
}
