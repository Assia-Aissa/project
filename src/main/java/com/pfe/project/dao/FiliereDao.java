package com.pfe.project.dao;


import com.pfe.project.modeles.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliereDao extends JpaRepository<Filiere,String> {


    Filiere findByNom(String nom);

    void deleteByNom(String nom);

}
