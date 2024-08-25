package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ForgotPasswordResponse {
    private String message;
    private String resetPasswordLink;
}
