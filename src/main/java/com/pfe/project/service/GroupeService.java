package com.pfe.project.service;

import com.pfe.project.dto.GroupeRequestDto;
import com.pfe.project.dto.GroupeResponseDto;

import java.util.List;

public interface GroupeService {

  GroupeResponseDto save(GroupeRequestDto groupeRequestDto);

  GroupeResponseDto findById(Integer id);

  GroupeResponseDto findByName(String nom);

  GroupeResponseDto update(GroupeRequestDto groupeRequestDto, Integer id);

  void delete(Integer id);

  List<GroupeResponseDto> findAll();
}
