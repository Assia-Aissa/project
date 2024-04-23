
package com.pfe.project.modeles;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Encadrant extends Professeur implements Serializable {



   private boolean archive;


}