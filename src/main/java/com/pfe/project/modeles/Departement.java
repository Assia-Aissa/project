
package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;
@Table(name = "departements")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement implements Serializable {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name = "dnom", nullable = false)
   private String nom ;

   private  String Description ;
   private String  Responsable ;



   @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL)

   private List<Professeur> professeurs;


   // In your Departement entity
   @ManyToOne
   @JoinColumn(name = "administrateur_id")
   private Administrateur administrateur;

   @OneToMany(mappedBy="departement", cascade = CascadeType.ALL)
   private List<Filiere> filieres;









}