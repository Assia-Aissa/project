package com.pfe.project.controllers;

import com.pfe.project.dto.ForgotPasswordRequest;
import com.pfe.project.dto.ForgotPasswordResponse;
import com.pfe.project.dto.ResetPasswordRequest;
import com.pfe.project.service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
public class ForgotasswordController {
    @Autowired
    private ForgotPasswordService service;

    @PostMapping("/forgot-password")
    public ForgotPasswordResponse forgotPass(@RequestBody ForgotPasswordRequest request) {
        String token = service.forgotPass(request.getEmail());

        if (token.startsWith("Invalid")) {
            return new ForgotPasswordResponse("Invalid email id.", null);
        }

        String resetPasswordLink = "http://localhost:3000/reset-password?token=" + token;
        return new ForgotPasswordResponse("Password reset link generated.", resetPasswordLink);
    }

    @PutMapping("/reset-password")
    public String resetPass(@RequestBody ResetPasswordRequest request) {
        return service.resetPass(request.getToken(), request.getPassword());
    }
}
