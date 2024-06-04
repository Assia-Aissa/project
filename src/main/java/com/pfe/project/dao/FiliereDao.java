package com.pfe.project.dao;

import com.pfe.project.modeles.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliereDao extends JpaRepository<Filiere,Integer> {

    Filiere findByNom(String nom);

<<<<<<< HEAD



=======
    // You can add custom repository methods if needed
>>>>>>> c2f3445d0fd1a9f58c09faae1812c97b825b2596
}
