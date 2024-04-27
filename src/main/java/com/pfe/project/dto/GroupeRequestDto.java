package com.pfe.project.dto;



import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupeRequestDto {

    @NotNull(message = "le nombre de groupe  est obligatoire")
    private Integer id;

    @NotNull(message = "les noms est obligatoire")
    private String nom;
}
