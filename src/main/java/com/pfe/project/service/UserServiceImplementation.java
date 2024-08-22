package com.pfe.project.service;

import com.pfe.project.dao.UserDao;
import com.pfe.project.modeles.Role;
import com.pfe.project.modeles.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserServiceImplementation implements UserDetailsService, UserService {
    @Autowired
    private  UserDao userDao;


    // Constructor Injection
    @Autowired
    public UserServiceImplementation(UserDao userDao) {
        this.userDao = userDao;

    }

    private Map<User, String> tokenRegister = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with this email: " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Add roles and other authorities here if needed
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }


    @Override
    public List<User> getAllUser() {
        return List.of();
    }

    @Override
    public User findUserProfileByJwt(String jwt) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserById(String userId) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }

    @Override
    public List<User> findByRole(Role role) {
        return userDao.findByRole(role);
    }


}
