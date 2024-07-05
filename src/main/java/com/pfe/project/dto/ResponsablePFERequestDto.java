package com.pfe.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsablePFERequestDto extends EncadrantRequestDto{

    private boolean responsable;
}
