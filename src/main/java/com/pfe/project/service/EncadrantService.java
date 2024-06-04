package com.pfe.project.service;

import com.pfe.project.dto.EncadrantRequestDto;
import com.pfe.project.dto.EncadrantResponseDto;
import java.util.List;

public interface EncadrantService {
    EncadrantResponseDto save(EncadrantRequestDto encadrantRequestDto);

    EncadrantResponseDto findById(Integer id);

    EncadrantResponseDto update(EncadrantRequestDto encadrantRequestDto, Integer id);

    void delete(Integer id);

    List<EncadrantResponseDto> findAll();
}
