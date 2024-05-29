package com.pfe.project.service;

import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import java.util.List;

public interface EtudiantService {

   EtudiantResponseDto save(EtudiantRequestDto etudiantRequestDto);


   EtudiantResponseDto findById(Integer id);

   EtudiantResponseDto findByNom(String nom);

   void delete(Integer id);


   EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer id) ;

   List<EtudiantResponseDto> findAll();

}
