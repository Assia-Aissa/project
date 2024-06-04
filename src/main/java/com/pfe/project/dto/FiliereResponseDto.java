package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiliereResponseDto {

    private String nom;

    private String description;

    // Corrected field name to follow Java conventions
    private String responsable;
}
