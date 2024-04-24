
package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filiere implements Serializable {

   @Id
   @Column(nullable = false)
   private String fnom;


   @ManyToOne
   private Departement departement;

   @OneToMany

   private List<Etudiant> etudiants;


}