package com.pfe.project.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Set;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {




    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Set<String> roles= AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ADMIN")) {
            response.sendRedirect("/admin/dashboard");
        } else if (roles.contains("ENCADRANT")) {
            response.sendRedirect("/encadrant/dashboard");
        } else if (roles.contains("ETUDIANT")) {
            response.sendRedirect("/etudiant/dashboard");
        } else if (roles.contains("RESPONSABLE")) {
            response.sendRedirect("/responsable/dashboard");
        } else {
            response.sendRedirect("/login?error");
        }
    }
}
