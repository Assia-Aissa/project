package com.pfe.project.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesseurRequestDto {



    @NotNull(message = "le nom est obligatoire")
    private String nom;

    @NotNull(message = "le prenom est obligatoire")
    private String prenom;

    @NotNull(message = "email est obligatoire")
    private String email;

    @NotBlank
    private String password;

    @NotNull
    @Pattern(regexp="^(\\+212|0)([\\-_/]*)([\\d\\-_/]*){9}$", message = "format invalid")
    private String telephone;
}
