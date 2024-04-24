package com.pfe.project.service;

import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;

public interface EtudiantService {
   EtudiantResponseDto save(EtudiantRequestDto etudiantRequestDto);

   EtudiantResponseDto findById(Integer id);

   EtudiantResponseDto findByNom(String etnom);

   void delete(Integer id);

   EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer id) ;

}
