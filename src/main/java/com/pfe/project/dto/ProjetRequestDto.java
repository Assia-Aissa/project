package com.pfe.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetRequestDto {

    @NotNull(message = "Le titre est obligatoire")
    private String titre;

    @NotNull(message = "L'objectif est obligatoire")
    private String objectif;

    @NotNull(message = "La date de création est obligatoire")
    private Date dateCreation;
}
