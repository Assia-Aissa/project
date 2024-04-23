package com.pfe.project.modeles;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

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

}