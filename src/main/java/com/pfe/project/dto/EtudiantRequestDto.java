package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EtudiantRequestDto {

    private String etnom;
    private String etprenom;

    private String adressEmail;
    private  Integer codeApogee;
    private  int telephone;
    private String motDePasse;

}
