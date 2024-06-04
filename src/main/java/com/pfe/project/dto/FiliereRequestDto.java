package com.pfe.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiliereRequestDto {

    @NotNull(message = "Filiere!!")
    private String nom;

    @NotNull(message = "le description  est obligatoire")
    private String description;

<<<<<<< HEAD
    @NotNull(message = "le responsable est obligatoire !!")
=======
    // Corrected field name to follow Java conventions
>>>>>>> c2f3445d0fd1a9f58c09faae1812c97b825b2596
    private String responsable;
}
