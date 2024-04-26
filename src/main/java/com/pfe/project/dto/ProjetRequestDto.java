package com.pfe.project.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetRequestDto {


    @NotNull(message = "le titre est obligatoire")
    @Size(min = 3, max = 25, message = "la nombre de character doit compris entre 3 et 25")
    private String titre;

     @NotNull(message = " objective est obligatoire")
     private String objectif;

     @NotNull(message = "la date de creation ")
    private Date dateCreation;




}
