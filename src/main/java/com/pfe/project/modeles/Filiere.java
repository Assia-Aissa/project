
package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;
@Table(name = "Filieres")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filiere implements Serializable {

   @Id
   @GeneratedValue
   private Integer idF;

   @Column(name="F_nom",nullable = false)
   private String nom;


   @Column(name="F_desc")
   private String description;
   @Column(name="F_respo",nullable = false)
  private String responsable;;

   @ManyToOne
   @JoinColumn(name = "nom_Filiere")
   private Departement departement;


   @OneToMany
   private List<Etudiant> etudiants;


}