
package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="etudiants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer id;
   @Column(name = "etnom")
   private String nom;
   @Column(nullable = false)
   private String etprenom;
   @Column(nullable = false)
   private String adressEmail;
   @Column(nullable = false)
   private  int codeApogee;
   @Column(nullable = false)
   private  String telephone;
   @Column(nullable = false)
   private String mot_de_Passe;

   @Column(nullable = false)
   private boolean accepted; // Add this field to track acceptance status
   @Column(name = "role")
   private boolean responsable;
   // Method to get the full name
   public String getFullName() {
      return etprenom + " " + nom;
   }



   @ManyToOne
   private Filiere filiere;


}