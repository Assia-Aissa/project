package com.pfe.project.modeles;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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