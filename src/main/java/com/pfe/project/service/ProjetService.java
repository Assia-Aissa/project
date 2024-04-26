package com.pfe.project.service;


import com.pfe.project.dto.ProjetRequestDto;
import com.pfe.project.dto.ProjetResponseDto;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import java.util.List;

public interface ProjetService {



    ProjetResponseDto save(ProjetRequestDto projetRequestDto);

    ProjetResponseDto findByName(String titre);

    ProjetResponseDto update(ProjetRequestDto projetRequestDto , String titre)throws NotFoundException;

    void delete(String titre);

    List<ProjetResponseDto> findAll();



}
