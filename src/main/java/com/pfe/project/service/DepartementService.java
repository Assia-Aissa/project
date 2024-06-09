package com.pfe.project.service;


import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface DepartementService {

    DepartementResponseDto save(DepartementRequestDto departementRequestDto);

    List<DepartementResponseDto> findAll();

    DepartementResponseDto findById(Integer id);


    DepartementResponseDto update(DepartementRequestDto departementRequestDto,Integer id) ;
    void delete(Integer id);
}