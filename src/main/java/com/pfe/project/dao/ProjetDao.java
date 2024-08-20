package com.pfe.project.dao;


import com.pfe.project.modeles.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetDao extends JpaRepository<Projet,Integer> {
    List<Projet> findByArchiver(boolean isArchived);



}
