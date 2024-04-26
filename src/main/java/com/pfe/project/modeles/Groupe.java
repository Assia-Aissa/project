
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
   private int numero;

   @Column(nullable = false)
   private String membres;

   @OneToMany(mappedBy="groupe", cascade = CascadeType.ALL)
   private List<Etudiant> etudiants;

   @OneToOne
   private Projet projet;

   @ManyToOne
   @JoinColumn(name = "responsable_pfe_id")
   private ResponsablePFE responsablePFE ;

}