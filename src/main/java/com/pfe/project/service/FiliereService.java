package com.pfe.project.service;

import com.pfe.project.dto.FiliereRequestDto;
import com.pfe.project.dto.FiliereResponseDto;

import java.util.List;

public interface
FiliereService {

    FiliereResponseDto save (FiliereRequestDto filiereRequestDto);

    FiliereResponseDto findById(Integer idF);

    FiliereResponseDto findByNom(String nom);

    void delete(Integer idF);
    FiliereResponseDto update(FiliereRequestDto filiereRequestDto,Integer idF);

    List<FiliereResponseDto> findAll();


}
