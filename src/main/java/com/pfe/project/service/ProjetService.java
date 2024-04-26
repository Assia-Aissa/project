package com.pfe.project.service;


import com.pfe.project.dto.ProjetRequestDto;
import com.pfe.project.dto.ProjetResponseDto;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import java.util.List;

public interface ProjetService {



    ProjetResponseDto save(ProjetRequestDto projetRequestDto);

    ProjetResponseDto findByNom(String nom);

    ProjetResponseDto update(ProjetRequestDto projetRequestDto , String nom)throws NotFoundException;

    void delete(String nom);

    List<ProjetResponseDto> findAll();



}
