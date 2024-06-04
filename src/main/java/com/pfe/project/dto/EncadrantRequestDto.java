package com.pfe.project.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EncadrantRequestDto extends ProfesseurRequestDto {

    @NotNull(message = "le archive est obligatoire!!")
    private boolean archive;

    @NotNull(message = "le role est obligatoire!!")
    private String role;

    // Uncomment and use this if needed
    // private List<Integer> projetIds;
}

