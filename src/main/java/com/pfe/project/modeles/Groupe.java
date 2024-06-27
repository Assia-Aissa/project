
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

    public void setProject(Projet project) {
    }


   public List<Etudiant> getEtudiants() {
       return null;
   }


   public void setEtudiants(List<Etudiant> etudiants) {
   }
}