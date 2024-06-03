package com.pfe.project.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesseurResponseDto {

    private Integer identifier;

    private String nom;



    private String email;

    private String password;

    private String telephone;
}
