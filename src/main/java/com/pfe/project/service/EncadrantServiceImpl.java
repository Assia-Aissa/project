package com.pfe.project.service;

import com.pfe.project.dao.EncadrantDao;
import com.pfe.project.dto.EncadrantRequestDto;
import com.pfe.project.dto.EncadrantResponseDto;
import com.pfe.project.modeles.Encadrant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class EncadrantServiceImpl implements EncadrantService {

    @Autowired
    private EncadrantDao encadrantDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EncadrantResponseDto save(EncadrantRequestDto encadrantRequestDto) {
        Encadrant encadrant = modelMapper.map(encadrantRequestDto, Encadrant.class);
        Encadrant savedEncadrant = encadrantDao.save(encadrant);
        return modelMapper.map(savedEncadrant, EncadrantResponseDto.class);
    }

    @Override
    public EncadrantResponseDto findById(Integer id) {
        Encadrant encadrant = encadrantDao.findById(id).orElseThrow(() -> new RuntimeException("Encadrant not found"));
        return modelMapper.map(encadrant, EncadrantResponseDto.class);
    }

    @Override
    public EncadrantResponseDto update(EncadrantRequestDto encadrantRequestDto, Integer id) {
        Encadrant encadrant = encadrantDao.findById(id).orElseThrow(() -> new RuntimeException("Encadrant not found"));
        modelMapper.map(encadrantRequestDto, encadrant);
        Encadrant updatedEncadrant = encadrantDao.save(encadrant);
        return modelMapper.map(updatedEncadrant, EncadrantResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        encadrantDao.deleteById(id);
    }

    @Override
    public List<EncadrantResponseDto> findAll() {
        return encadrantDao.findAll().stream()
                .map(encadrant -> modelMapper.map(encadrant, EncadrantResponseDto.class))
                .collect(Collectors.toList());
    }
}
