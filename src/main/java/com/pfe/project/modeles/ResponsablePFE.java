package com.pfe.project.modeles;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsablePFE extends Encadrant implements Serializable {


   @Column(nullable = false)
   private boolean responsable;

}