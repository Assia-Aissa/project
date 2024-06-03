package com.pfe.project.controllers;

import com.pfe.project.dao.EncadrantDao;
import com.pfe.project.dao.EtudiantDao;
import com.pfe.project.dao.UserDao;
import com.pfe.project.modeles.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @GetMapping("/")
    public String index() {
        return "this is needing authentication";
    }

    @PostMapping("user/save")
    public ResponseEntity<Object> saveUser(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Users result = userDao.save(user);
        if (result.getId() > 0) {
            return ResponseEntity.ok("user was saved");
        }
        return ResponseEntity.status(404).body("User was not saved");
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminDashboard() {
        return "Admin Dashboard";
    }

    @GetMapping("/encadrant/dashboard")
    @PreAuthorize("hasAuthority('ENCADRANT')")
    public String encadrantDashboard() {
        return "Encadrant Dashboard";
    }

    @GetMapping("/etudiant/dashboard")
    @PreAuthorize("hasAuthority('ETUDIANT')")
    public String etudiantDashboard() {
        return "Etudiant Dashboard";
    }

    @GetMapping("/responsable/dashboard")
    @PreAuthorize("hasAuthority('RESPONSABLE')")
    public String responsableDashboard() {
        return "Responsable Dashboard";
    }


    public UserDetails getLoggedInUserDetails(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.getPrincipal() instanceof UserDetails){
            return (UserDetails) authentication.getPrincipal();

        }
        return null;
    }
}
