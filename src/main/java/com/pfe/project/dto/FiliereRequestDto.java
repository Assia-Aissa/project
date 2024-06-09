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

    private String description;


    private String responsable;
}
