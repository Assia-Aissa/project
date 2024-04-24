
package com.pfe.project.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {

   @Id
   @Column(nullable = false)
   private String etnom;
   @Column(nullable = false)
   private String etprenom;
   @Column(nullable = false)
   private String adressEmail;
   @Column(nullable = false)
   private  int codeApogee;
   @Column(nullable = false)
   private  String telephone;
   @Column(nullable = false)
   private String motDePasse;

   @ManyToOne
   private Filiere filiere;

   @ManyToOne
   private Groupe groupe;
}