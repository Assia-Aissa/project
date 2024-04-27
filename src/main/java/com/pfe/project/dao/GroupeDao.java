package com.pfe.project.dao;

import com.pfe.project.modeles.Groupe;
import com.pfe.project.modeles.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeDao extends JpaRepository<Groupe,Integer> {


   Groupe findByNom(String nom);

}
