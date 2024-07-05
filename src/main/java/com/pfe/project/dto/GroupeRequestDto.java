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



    @NotNull(message = "le nom est obligatoire")
    private String nom;
    @NotNull(message = "La liste des étudiants est obligatoire")
    private List<Integer> etudiantIds;


}
