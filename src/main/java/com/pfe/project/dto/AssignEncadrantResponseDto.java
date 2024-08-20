package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignEncadrantResponseDto {
    private Integer EncadrantId;
    private String EncadrantNom;
    private String EncadrantEmail;
    private Integer groupId;
    private String groupNom;

}

