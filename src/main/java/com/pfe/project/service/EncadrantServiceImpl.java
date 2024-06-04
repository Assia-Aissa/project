package com.pfe.project.service;

import com.pfe.project.Exception.EntityAlreadyExistsException;
import com.pfe.project.dao.EncadrantDao;
import com.pfe.project.dto.EncadrantRequestDto;
import com.pfe.project.dto.EncadrantResponseDto;
import com.pfe.project.modeles.Encadrant;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EncadrantServiceImpl implements EncadrantService {

    private final EncadrantDao encadrantDao;
    private final ModelMapper modelMapper;

    @Override
    public EncadrantResponseDto save(EncadrantRequestDto encadrantRequestDto) {
        Encadrant encadrant = modelMapper.map(encadrantRequestDto, Encadrant.class);
        Encadrant saved = encadrantDao.save(encadrant);
        return modelMapper.map(saved, EncadrantResponseDto.class);
    }

    @Override
    public EncadrantResponseDto findById(Integer id) {
        Encadrant encadrant = encadrantDao.findById(id).orElseThrow(() -> new RuntimeException("Encadrant not found"));
        return modelMapper.map(encadrant, EncadrantResponseDto.class);
    }

    @Override
    public EncadrantResponseDto update(EncadrantRequestDto encadrantRequestDto, Integer id) {
        Optional<Encadrant> encadrantFound = encadrantDao.findById(id);
        if (encadrantFound.isPresent()) {
            Encadrant encadrant = encadrantFound.get();
            modelMapper.map(encadrantRequestDto, encadrant);
            encadrant.setId(id);
            Encadrant updated = encadrantDao.save(encadrant);
            return modelMapper.map(updated, EncadrantResponseDto.class);
        } else {
            throw new EntityAlreadyExistsException("Encadrant non trouvé");
        }
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
