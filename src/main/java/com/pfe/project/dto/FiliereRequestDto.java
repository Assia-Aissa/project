package com.pfe.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiliereRequestDto {

    @NotNull(message = "Filiere!!")
    private String nom;

    @NotNull(message = "le description  est obligatoire")
    private String description;

    @NotNull(message = "le responsable est obligatoire !!")
    private String responsable;
}
