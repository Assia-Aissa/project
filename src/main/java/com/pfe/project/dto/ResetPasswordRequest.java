package com.pfe.project.dto;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String token;
    private String password;
}
