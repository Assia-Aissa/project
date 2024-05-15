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
    private String nom;

    @NotNull(message = "le prénom est obligatoire!!")
    private String etprenom;

    @NotNull(message = " adresse-Email est obligatoire!!")
    private String adressEmail;

    @NotNull(message = "Code Apogee est obligatoire !!")
    private  int codeApogee;


    @NotNull
    @Pattern(regexp = "^(\\+212|0)([\\-_/]*)([\\d\\-_/]*){9}$", message = "format invalid")
    private  String telephone;

    @NotNull(message = "le mot de passe est obligatoire !!")
    //@Size( max = 25, message = "mot de pass de size > 25 caractere")
    private String mot_de_Passe;




}
