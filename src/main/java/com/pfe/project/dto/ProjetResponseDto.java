package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetResponseDto {

    private Integer id;
    private String titre;
    private String objectif;
    private String date_creation;

}
