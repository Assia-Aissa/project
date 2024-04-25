package com.pfe.project.dto;

import com.pfe.project.modeles.Filiere;
import com.pfe.project.modeles.Groupe;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantRequestDto {

    @NotNull(message = "le nom est obligatoire!!")
    @Size(min = 3, max = 20, message = "la nombre de character doit compris entre 3 et 20")
    private String nom;

    @NotNull(message = "le prénom est obligatoire!!")
    @Size(min = 3, max = 20, message = "la nombre de character doit compris entre 3 et 20")
    private String etprenom;

    @NotNull(message = " adresse-Email est obligatoire!!")
    private String adressEmail;

    @NotNull(message = "Code Apogee est obligatoire !!")
    private  Integer codeApogee;


    @NotNull
    @Pattern(regexp="^(\\+212|0)([\\-_/]*)([\\d\\-_/]*){9}$", message = "format invalid")
    private  String telephone;

    @NotNull(message = "le mot de passe est obligatoire !!")
    private String motDePasse;




}
