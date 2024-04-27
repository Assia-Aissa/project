package com.pfe.project.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementRequestDto {

    @NotNull(message = "le nom de Département est obligatoire")
    private String nom ;

}
