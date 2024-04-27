package com.pfe.project.dao;


import com.pfe.project.modeles.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementDao extends JpaRepository<Departement,String> {

    Departement findByName( String nom);




}
