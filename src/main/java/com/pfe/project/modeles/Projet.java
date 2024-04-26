
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
   @Column(nullable = false,name = "titre")
   private String nom;
   @Column(nullable = false)
   private String objectif;
   @Column(nullable = false)
   private Date dateCreation;
   @Column(nullable = false)
   private boolean cacher;

   //many project created by the encadrant
   @ManyToOne
   private Encadrant encadrant;

   @OneToOne
   @JoinColumn(name="groupe")
   private Groupe groupe;

}