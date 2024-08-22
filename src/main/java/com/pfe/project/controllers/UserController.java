package com.pfe.project.controllers;


import com.pfe.project.SecurityConfig.JwtProvider;
import com.pfe.project.dao.UserDao;
import com.pfe.project.dto.AuthResponse;
import com.pfe.project.modeles.Role;
import com.pfe.project.modeles.User;
import com.pfe.project.service.UserService;
import com.pfe.project.service.UserServiceImplementation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImplementation customUserDetails;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        String fullName = user.getFullName();
        String telephone = user.getTelephone();
        Role role = user.getRole();

        // Check if the email already exists
        Optional<User> isEmailExist = Optional.ofNullable(userDao.findByEmail(email));
        if (isEmailExist.isPresent()) {
            return new ResponseEntity<>(new AuthResponse(null, "Email is already used with another account", false), HttpStatus.BAD_REQUEST);
        }

        // Create a new user
        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setFullName(fullName);
        createdUser.setTelephone(telephone);
        createdUser.setRole(role != null ? role : Role.ETUDIANT);  // Default role if not provided
        createdUser.setPassword(passwordEncoder.encode(password));

        // Save the user to the database
        User savedUser = userDao.save(createdUser);

        // Generate JWT token
        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = JwtProvider.generateToken(authentication);

        // Prepare the response
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Register Success");
        authResponse.setStatus(true);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody User loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        try {
            Authentication authentication = authenticate(email, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = JwtProvider.generateToken(authentication);

            AuthResponse authResponse = new AuthResponse();
            authResponse.setJwt(token);
            authResponse.setMessage("Login success");
            authResponse.setStatus(true);

            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AuthResponse(null, "Invalid username or password", false), HttpStatus.UNAUTHORIZED);
        }
    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customUserDetails.loadUserByUsername(username);

        if (userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }





}
