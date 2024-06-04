package com.pfe.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupeRequestDto {

    @NotNull(message = "le nombre de groupe est obligatoire")
    private Integer id;

    @NotNull(message = "le nom est obligatoire")
    private String nom;

    // Change to list of student names
    @NotNull
    private List<String> etudiantsNames;
}
