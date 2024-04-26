package com.pfe.project.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetResponseDto {




    private String titre;

    private String objectif;


    private Date dateCreation;



}
