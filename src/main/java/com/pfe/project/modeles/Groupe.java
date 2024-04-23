
package com.pfe.project.modeles;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Groupe implements Serializable {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private int numero;

   @Column(nullable = false)
   private String membres;





}