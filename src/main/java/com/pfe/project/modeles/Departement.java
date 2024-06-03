package com.pfe.project.modeles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "departements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @NotBlank
   @Column(name = "dnom", nullable = false)
   private String nom;

   @NotBlank
   @Column(name = "desc", nullable = false)
   private String description;

   @NotBlank
   @Column(name = "respo", nullable = false)
   private String responsable;

   @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
   private List<Professeur> professeurs;

   @ManyToOne
   @JoinColumn(name = "administrateur_id")
   private Administrateur administrateur;

   @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
   private List<Filiere> filieres;
}
