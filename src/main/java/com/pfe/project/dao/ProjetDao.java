package com.pfe.project.dao;


import com.pfe.project.modeles.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDao extends JpaRepository<Projet,Integer> {

    Projet findByNom(String titre);

    void deleteByName(String titre);


}
