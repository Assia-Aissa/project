package com.pfe.project.dao;

import com.pfe.project.modeles.Encadrant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncadrantDao extends JpaRepository<Encadrant, Integer> {

    //all methods are in jpa repository
}
