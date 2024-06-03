package com.pfe.project.service;

import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;

import java.util.List;

public interface DepartementService {

    DepartementResponseDto save(DepartementRequestDto requestDto);

    DepartementResponseDto findByNom(String nom);

    DepartementResponseDto update(DepartementRequestDto requestDto, Integer id);

    List<DepartementResponseDto> findAll();
}
