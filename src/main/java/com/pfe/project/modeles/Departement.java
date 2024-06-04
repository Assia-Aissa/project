package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Table(name = "departements")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(name = "nom", nullable = false)
   private String nom;

   @Column(name = "description", nullable = false)
   private String description;

   @Column(name = "responsable", nullable = false)
   private String responsable;

   @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
   private List<Professeur> professeurs;

   @ManyToOne
   @JoinColumn(name = "administrateur_id")
   private Administrateur administrateur;

   @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
   private List<Filiere> filieres;
}
