package com.pfe.project.modeles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="profs")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Professeur implements Serializable {

   @Setter
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer identifier;
   @Column(nullable = false)
   private String nom;

   @Column(nullable = false)
   private String email;
   @Column(nullable = false)
   private String password;
   @Column(nullable = false)
   private String telephone;

   private String role;


   @ManyToOne
   @JoinColumn(name="dept_nom")
   private Departement departement;

}