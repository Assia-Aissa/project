package com.pfe.project.service;

import com.pfe.project.dto.*;
import com.pfe.project.modeles.Groupe;

import java.util.List;

public interface EncadrantService {
    EncadrantResponseDto save(EncadrantRequestDto encadrantRequestDto);

    EncadrantResponseDto findById(Integer id);

    EncadrantResponseDto update(EncadrantRequestDto encadrantRequestDto, Integer id);

    AssignEncadrantResponseDto assignEncadrantToGroup(AssignEncadrantDto assignEncadrantDto);


    void delete(Integer id);

    List<EncadrantResponseDto> findAll();


    List<Groupe> findGroupsWithoutEncadrant();
}