package com.pfe.project.dao;

import com.pfe.project.modeles.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant,Integer> {

    Etudiant findByNom(String etnom);

}
