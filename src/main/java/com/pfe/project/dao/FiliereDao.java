package com.pfe.project.dao;

import com.pfe.project.modeles.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FiliereDao extends JpaRepository<Filiere,Integer> {

    Filiere findByNom(String nom);

}
