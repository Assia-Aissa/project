package com.pfe.project.modeles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrateur implements Serializable {
   @Id
   @GeneratedValue
   private int id;
   @Column(nullable = false)
   private String email;
   @Column(nullable = false)
   private int password;

   @OneToMany(mappedBy = "administrateur")
   @JoinColumn(name="departement")
   private List<Departement> departements;
}