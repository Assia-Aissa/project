package com.pfe.project.service;

import com.pfe.project.dto.ProfesseurRequestDto;
import com.pfe.project.dto.ProfesseurResponseDto;

import java.util.List;

public interface
ProfesseurService {

    ProfesseurResponseDto save(ProfesseurRequestDto professeurRequestDto);

    ProfesseurResponseDto findById(Integer identifier);

    ProfesseurResponseDto findByNom(String nom);

    //we need to throw a not found exception for the update
    ProfesseurResponseDto update(ProfesseurRequestDto professeurRequestDto,Integer identifier);

    void delete(Integer identifier);

    List<ProfesseurResponseDto> findAll();
}
