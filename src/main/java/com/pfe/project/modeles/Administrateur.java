package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrateur implements Serializable {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int id;

   @Column(nullable = false)
   private String email;

   @Column(nullable = false)
   private String password;

   @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL)
   private List<Departement> departements;
}
