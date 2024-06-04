package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Table(name = "Encadrants")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Encadrant extends Professeur implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private boolean archive;

   private String role;

   @OneToMany(mappedBy = "encadrant", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Projet> projets;

   // The explicit setter for id is not needed as Lombok's @Data annotation generates it
}
