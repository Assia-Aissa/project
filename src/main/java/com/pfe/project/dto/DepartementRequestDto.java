package com.pfe.project.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementRequestDto {


    @NotBlank
    private String nom ;

    @NotBlank
    private String Description ;

    @NotBlank
    private  String Responsable  ;


}
