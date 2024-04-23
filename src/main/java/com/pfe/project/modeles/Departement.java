
package com.pfe.project.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement implements Serializable {

   @Id
   @Column(nullable = false)
   private String dnom;






}