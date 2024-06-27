
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
@Table(name = "Projets")
public class Projet implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @Column(nullable = false,name = "titre")
   private String titre;
   @Column(nullable = false)
   private String objectif;
   @Column(nullable = false)
   private String date_creation;

   private boolean archiver;

   //many project created by the encadrant
   @ManyToOne
  private Encadrant encadrant;

   @OneToOne
   @JoinColumn(name="groupe")
   private Groupe groupe;

    public void setEtudiants(List<Etudiant> collect) {
    }


}