package com.pfe.project.service;


import com.pfe.project.dao.ResponsablePFEDao;
import com.pfe.project.dto.ResponsablePFERequestDto;
import com.pfe.project.dto.ResponsablePFEResponseDto;
import com.pfe.project.modeles.ResponsablePFE;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResponsablePFEServiceImpl implements ResponsablePFEService{

    @Autowired
    private ResponsablePFEDao responsablePFEDao;
    private ModelMapper modelMapper;

    @Override
    public ResponsablePFEResponseDto save(ResponsablePFERequestDto responsablePFERequestDto) {
        ResponsablePFE responsablePFE = modelMapper.map(responsablePFERequestDto, ResponsablePFE.class);
        ResponsablePFE saved = responsablePFEDao.save(responsablePFE);
        return modelMapper.map(saved, ResponsablePFEResponseDto.class);
    }

    @Override
    public ResponsablePFEResponseDto findById(Integer identifier) {
        ResponsablePFE responsablePFE = responsablePFEDao.findById(identifier).orElseThrow(
                () -> new RuntimeException("ResponsablePFE not found"));
        return modelMapper.map(responsablePFE, ResponsablePFEResponseDto.class);
    }

    @Override
    public ResponsablePFEResponseDto update(ResponsablePFERequestDto responsablePFERequestDto, Integer identifier) {
        Optional<ResponsablePFE> responsablePFEFound = responsablePFEDao.findById(identifier);
        if (responsablePFEFound.isPresent()) {
            ResponsablePFE responsablePFE = responsablePFEFound.get();
            modelMapper.map(responsablePFERequestDto, responsablePFE);
            responsablePFE.setIdentifier(identifier);
            ResponsablePFE updated = responsablePFEDao.save(responsablePFE);
            return modelMapper.map(updated, ResponsablePFEResponseDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer identifier) {
        responsablePFEDao.deleteById(identifier);
    }

    @Override
    public List<ResponsablePFEResponseDto> findAll() {
        return responsablePFEDao.findAll().stream()
                .map(element -> modelMapper.map(element, ResponsablePFEResponseDto.class))
                .collect(Collectors.toList());
    }
}
