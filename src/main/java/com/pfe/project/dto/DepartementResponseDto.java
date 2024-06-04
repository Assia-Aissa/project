package com.pfe.project.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementResponseDto {

    private  Integer id;
     private  String nom ;
     private  String Description ;
     private String  Responsable ;
}

