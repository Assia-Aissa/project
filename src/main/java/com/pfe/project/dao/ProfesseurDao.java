package com.pfe.project.dao;

import com.pfe.project.modeles.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesseurDao extends JpaRepository<Professeur,Integer> {

    Professeur findByNom(String nom);




}
