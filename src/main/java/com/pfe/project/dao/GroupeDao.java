package com.pfe.project.dao;

import com.pfe.project.modeles.Groupe;
import com.pfe.project.modeles.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupeDao extends JpaRepository<Groupe,Integer> {

   @Query("SELECT g FROM Groupe g LEFT JOIN g.encadrants e WHERE e IS NULL")
   List<Groupe> findGroupsWithoutEncadrant();


   Groupe findByNom(String nom);

}
