package com.pfe.project.dao;

import com.pfe.project.modeles.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgotPasswordRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByToken(String token);
}
