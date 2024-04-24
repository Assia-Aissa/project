
package com.pfe.project.modeles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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

   @OneToMany(mappedBy="groupe")
   @JoinColumn(name="Members")
   private List<Etudiant> etudiants;

   @OneToOne
   private Projet projet;

   @ManyToOne
   private ResponsablePFE responsablePFE ;

}