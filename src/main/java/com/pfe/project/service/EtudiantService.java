package com.pfe.project.service;

import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;

public interface EtudiantService {
   EtudiantResponseDto save(EtudiantRequestDto etudiantRequestDto);


   EtudiantResponseDto findById(Integer codeApogee);

   EtudiantResponseDto findByNom(String etnom);

   void delete(Integer codeApogee);

   EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer codeApogee) ;

}
