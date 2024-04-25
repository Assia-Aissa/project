package com.pfe.project.service;

import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import java.util.List;

public interface EtudiantService {
   EtudiantResponseDto save(EtudiantRequestDto etudiantRequestDto);


   EtudiantResponseDto findById(Integer codeApogee);

   EtudiantResponseDto findByNom(String nom);

   void delete(Integer codeApogee);


   EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer codeApogee) throws NotFoundException;

   List<EtudiantResponseDto> findAll();

}
