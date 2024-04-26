package com.pfe.project.service;

import com.pfe.project.dto.FiliereRequestDto;
import com.pfe.project.dto.FiliereResponseDto;

import java.util.List;

public interface FiliereService {

    FiliereResponseDto save (FiliereRequestDto filiereRequestDto);


    FiliereResponseDto findByNom(String nom);

    void delete(String nom);
    FiliereResponseDto update(FiliereRequestDto filiereRequestDto,String fnom);

    List<FiliereResponseDto> findAll();


}
