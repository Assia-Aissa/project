package com.pfe.project.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesseurRequestDto {

    @NotNull
    private String nom;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    @Pattern(regexp = "^(\\+212|0)([\\-_/]*)([\\d\\-_/]*){9}$", message = "format invalid")
    private String telephone;

    private Integer departement_id;
}
