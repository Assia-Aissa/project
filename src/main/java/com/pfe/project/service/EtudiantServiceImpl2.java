package com.pfe.project.service;

import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;
import org.springframework.stereotype.Service;

@Service("impl2")
public class EtudiantServiceImpl2 implements EtudiantService{
    @Override
    public EtudiantResponseDto save(EtudiantRequestDto etudiantRequestDto) {
        return null;
    }

    @Override
    public EtudiantResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public EtudiantResponseDto findByNom(String etnom) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer id) {
        return null;
    }
}
