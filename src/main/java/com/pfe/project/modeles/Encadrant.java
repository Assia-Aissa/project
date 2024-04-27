
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
@Inheritance(strategy = InheritanceType.JOINED)
public class
Encadrant extends Professeur implements Serializable {

   private boolean archive;


   @OneToMany(mappedBy = "encadrant",cascade = CascadeType.ALL)
   private List<Projet> projets;


}