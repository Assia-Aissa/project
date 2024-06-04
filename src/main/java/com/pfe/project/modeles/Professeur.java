package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="profs")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Professeur implements Serializable {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer identifier;
   @Column(nullable = false)
   private String nom;

   @Column(nullable = false)
   private String email;
   @Column(nullable = false)
   private String password;
   @Column(nullable = false)
   private String telephone;
   @Column(nullable = false)
   private String role;

   public void SetIdentifier(Integer identifier){
      this.identifier=identifier;
   }


   @ManyToOne
   @JoinColumn(name="professeur_nom")
   private Departement departement;
}