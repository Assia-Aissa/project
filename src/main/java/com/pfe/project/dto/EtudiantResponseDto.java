package com.pfe.project.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EtudiantResponseDto {

    private String etnom;
    private String etprenom;

    private String adressEmail;
    private  int codeApogee;
    private  int telephone;
    private int motDePasse;

}
