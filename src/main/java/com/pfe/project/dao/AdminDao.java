package com.pfe.project.dao;

import com.pfe.project.modeles.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Administrateur, Integer> {



}