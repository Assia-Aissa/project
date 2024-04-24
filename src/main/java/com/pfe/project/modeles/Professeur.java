package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Professeur implements Serializable {

   @Id
   @Column(nullable = false)
   private String nom;
   @Column(nullable = false)
   private String prenom;
   @Column(nullable = false)
   private String email;
   @Column(nullable = false)
   private String password;
   @Column(nullable = false)
   private String telephone;

   @ManyToOne
   private Departement departement;
}