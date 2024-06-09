package com.pfe.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementRequestDto {

    @NotBlank(message = "Name is important!!")
    private String nom;

    private String description;

    private String responsable;
}
