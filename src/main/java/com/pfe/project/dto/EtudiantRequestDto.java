package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EtudiantRequestDto {
    private Integer id;
    private String etnom;
    private String etprenom;

    private String adressEmail;
    private  int codeApogee;
    private  int telephone;
    private int motDePasse;

}
