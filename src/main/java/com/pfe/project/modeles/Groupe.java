
package com.pfe.project.modeles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Table(name = "groupes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Groupe implements Serializable {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name = "numero", nullable = false)
   private Integer id;

   @Column(name = "Name", nullable = false)
   private String nom;



   @OneToOne
   private Projet projet;

   @ManyToOne
   @JoinColumn(name = "responsable_pfe_id")
   private ResponsablePFE responsablePFE ;


   @ManyToMany
   @JoinTable(
           name = "groupe_etudiant",
           joinColumns = @JoinColumn(name = "groupe_id"),
           inverseJoinColumns = @JoinColumn(name = "etudiant_id")
   )
   private List<Etudiant> etudiants;


   public void setProject(Projet project) {
   }
}