package com.pfe.project.service;

import com.pfe.project.dto.ResponsablePFERequestDto;
import com.pfe.project.dto.ResponsablePFEResponseDto;

import java.util.List;

public interface ResponsablePFEService {

    ResponsablePFEResponseDto save(ResponsablePFERequestDto responsablePFERequestDto);
    ResponsablePFEResponseDto findById(Integer identifier);
    ResponsablePFEResponseDto update(ResponsablePFERequestDto responsablePFERequestDto, Integer identifier);
    void delete(Integer identifier);
    List<ResponsablePFEResponseDto> findAll();
}
