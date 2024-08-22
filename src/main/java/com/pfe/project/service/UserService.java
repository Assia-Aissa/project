package com.pfe.project.service;


import com.pfe.project.modeles.Role;
import com.pfe.project.modeles.User;

import java.util.List;


public interface UserService {


    public List<User> getAllUser()  ;

    public User findUserProfileByJwt(String jwt);

    public User findUserByEmail(String email) ;

    public User findUserById(String userId) ;

    public List<User> findAllUsers();

    List<User> findByRole(Role role);


}