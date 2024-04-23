package com.pfe.project.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Professeur implements Serializable {

   @Id
   @Column(nullable = false)
   private String nom;
   @Column(nullable = false)
   private String prenom;
   @Column(nullable = false)
   private String email;
   @Column(nullable = false)
   private int password;
   @Column(nullable = false)
   private int telephone;

}