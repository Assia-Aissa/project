
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

public class Projet implements Serializable {

   @Id
   @Column(nullable = false)
   private String titre;
   @Column(nullable = false)
   private String objectif;
   @Column(nullable = false)
   private Date dateCreation;
   @Column(nullable = false)
   private boolean cacher;

   //many project created by the encadrant
   @ManyToOne
   private Encadrant encadrant;

   @OneToOne(mappedBy="projet")
   @JoinColumn(name="Projet")
   private Groupe groupe;

}