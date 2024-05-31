
package com.pfe.project.modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
   private Integer id;

   @NotNull
   @Column(name = "dnom", nullable = false)
   private String nom ;

   @NotNull
   @Column(name = "desc", nullable = false)
   private  String Description ;

   @NotNull
   @Column(name = "respo", nullable = false)
   private String  Responsable ;


   public void SstID(Integer identifier){
      this.id=identifier;
   }


   @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL)

   private List<Professeur> professeurs;


   // In your Departement entity
   @ManyToOne
   @JoinColumn(name = "administrateur_id")
   private Administrateur administrateur;

   @OneToMany(mappedBy="departement", cascade = CascadeType.ALL)
   private List<Filiere> filieres;









}