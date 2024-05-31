package com.pfe.project.dao;

import com.pfe.project.modeles.ResponsablePFE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsablePFEDao extends JpaRepository<ResponsablePFE,Integer> {

    //all methods are in jpa repository
}
