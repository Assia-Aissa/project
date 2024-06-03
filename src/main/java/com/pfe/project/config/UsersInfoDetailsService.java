package com.pfe.project.config;

import com.pfe.project.dao.UserDao;
import com.pfe.project.modeles.Users;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class UsersInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user= userDao.findByEmail(username);

        return user.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("user Does not Exist"));
    }
}
