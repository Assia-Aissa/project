package com.pfe.project.service;


import com.pfe.project.dto.AssignProjectDTO;
import com.pfe.project.dto.ProjetRequestDto;
import com.pfe.project.dto.ProjetResponseDto;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import java.util.List;

public interface ProjetService {



    ProjetResponseDto save(ProjetRequestDto projetRequestDto);

    ProjetResponseDto findById(Integer id);

    ProjetResponseDto update(ProjetRequestDto projetRequestDto , Integer id)throws NotFoundException;

    void delete(Integer id);

    List<ProjetResponseDto> findAll();


    void assignProjectToGroup(AssignProjectDTO assignProjectDTO);
}
