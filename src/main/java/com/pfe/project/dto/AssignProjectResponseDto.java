package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignProjectResponseDto {

    private Integer projectId;
    private String projectTitle;
    private String projectCreationDate;
    private Integer groupId;
    private String groupNom;
}
