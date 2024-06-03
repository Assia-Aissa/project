package com.pfe.project.dto;


import com.pfe.project.modeles.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupeResponseDto {


    private Integer id;


    private String nom;

    private List<Etudiant> etudiants;
}
