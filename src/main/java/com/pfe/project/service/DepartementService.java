package com.pfe.project.service;


import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;

import java.util.List;

public interface DepartementService {

    DepartementResponseDto save(DepartementRequestDto departementRequestDto);

    DepartementResponseDto findByNom(String nom);
 DepartementResponseDto findById(Integer id);


    DepartementResponseDto update(DepartementRequestDto departementRequestDto, Integer id);

    List<DepartementResponseDto> findAll();
}
