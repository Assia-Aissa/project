package com.pfe.project.service;

import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("impl2")
public class EtudiantServiceImpl2 implements EtudiantService{
    @Override
    public EtudiantResponseDto save(EtudiantRequestDto etudiantRequestDto) {
        return null;
    }

    @Override
    public EtudiantResponseDto findById(Integer CodeApogee) {

        return null;
    }

    @Override
    public EtudiantResponseDto findByNom(String etnom) {
        return null;
    }

    @Override
    public void delete(Integer codeApogee) {

    }

    @Override
    public EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer codeApogee) {
        return null;
    }

    @Override
    public List<EtudiantResponseDto> findAll() {
        return List.of();
    }
}
