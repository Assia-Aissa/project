package com.pfe.project.service;

import com.pfe.project.dto.EncadrantRequestDto;
import com.pfe.project.dto.EncadrantResponseDto;

import java.util.List;

public interface EncadrantService {

    EncadrantResponseDto save(EncadrantRequestDto encadrantRequestDto);
    EncadrantResponseDto findById(Integer identifier);
    EncadrantResponseDto update(EncadrantRequestDto encadrantRequestDto, Integer identifier);
    void delete(Integer identifier);
    List<EncadrantResponseDto> findAll();

}
