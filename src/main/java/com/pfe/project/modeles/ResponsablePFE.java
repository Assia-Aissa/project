package com.pfe.project.modeles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Table(name = "Respo_Pfe")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsablePFE extends Encadrant implements Serializable {


   @Column(nullable = false)
   private boolean responsable;

   
   @OneToMany(mappedBy = "responsablePFE", cascade = CascadeType.ALL)
   private List<Groupe> groupes;

}