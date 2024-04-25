package com.pfe.project.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EtudiantResponseDto {

    private String nom;
    private String etprenom;

    private String adressEmail;
    private  Integer codeApogee;
    private  int telephone;
    private int motDePasse;

}
