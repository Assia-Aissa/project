package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EncadrantResponseDto extends ProfesseurResponseDto {

    private Integer id;
    private boolean archive;
    private String role;

    // Uncomment and import if you need to use this list
    // import java.util.List;
    // private List<ProjetRequestDto> projets;
}
