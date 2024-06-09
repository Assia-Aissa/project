package com.pfe.project.dao;

import com.pfe.project.modeles.Encadrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncadrantDao extends JpaRepository<Encadrant, Integer> {

    Encadrant findByNom(String nom);
}
