
package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement implements Serializable {

   @Id
   @Column(nullable = false)
   private String dnom;

   @OneToMany(mappedBy = "departement")
   @JoinColumn(name="professeur_nom")
   private List<Professeur> professeurs;

   @ManyToOne
   private Administrateur administrateur;

   @OneToMany(mappedBy="departement")
   @JoinColumn(name="nom_Filiere")
   private List<Filiere> filieres;





}