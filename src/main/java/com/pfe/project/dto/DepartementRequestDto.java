package com.pfe.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementRequestDto {

    @NotBlank
    private String nom;

    @NotBlank
    private String description;

    @NotBlank
    private String responsable;
}
