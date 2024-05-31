package com.pfe.project.service;


import com.pfe.project.dao.EncadrantDao;

import com.pfe.project.dto.EncadrantRequestDto;
import com.pfe.project.dto.EncadrantResponseDto;
import com.pfe.project.modeles.Encadrant;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EncadrantServiceImpl implements EncadrantService{
    @Autowired
    private EncadrantDao encadrantDao;
    private ModelMapper modelMapper;

    @Override
    public EncadrantResponseDto save(EncadrantRequestDto encadrantRequestDto) {
        Encadrant encadrant= modelMapper.map(encadrantRequestDto,Encadrant.class);
        Encadrant saved = encadrantDao.save(encadrant);
        return modelMapper.map(saved,EncadrantResponseDto.class);
    }

    @Override
    public EncadrantResponseDto findById(Integer identifier) {
        Encadrant encadrant = encadrantDao.findById(identifier).orElseThrow(
                () -> new RuntimeException("Encadrant not found"));
        return modelMapper.map(encadrant, EncadrantResponseDto.class);
    }

    @Override
    public EncadrantResponseDto update(EncadrantRequestDto encadrantRequestDto, Integer identifier) {
        Optional<Encadrant> encadrantFound = encadrantDao.findById(identifier);
        if (encadrantFound.isPresent()) {
            Encadrant encadrant = encadrantFound.get();
            modelMapper.map(encadrantRequestDto, encadrant);
            encadrant.setIdentifier(identifier);
            Encadrant updated = encadrantDao.save(encadrant);
            return modelMapper.map(updated, EncadrantResponseDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer identifier) {
        encadrantDao.deleteById(identifier);
    }

    @Override
    public List<EncadrantResponseDto> findAll() {
        return encadrantDao.findAll().stream()
                .map(element -> modelMapper.map(element, EncadrantResponseDto.class))
                .collect(Collectors.toList());
    }
}
