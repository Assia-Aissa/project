package com.pfe.project.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantResponseDto {


    private Integer id;
    private String nom;
    private String etprenom;

    private String adressEmail;
    private  int codeApogee;
    private  String  telephone;
    private String mot_de_Passe;

}
