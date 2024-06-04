package com.pfe.project.dao;

import com.pfe.project.modeles.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<Users,Integer> {

    @Query(value = "select * from users where email = ?1", nativeQuery = true)
    Optional<Users> findByEmail(String email);
}
