package com.pfe.project.dao;

import com.pfe.project.modeles.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant,Integer> {

    Etudiant findByNom(String nom);
    List<Etudiant> findAllById(Iterable<Integer> ids);

}
