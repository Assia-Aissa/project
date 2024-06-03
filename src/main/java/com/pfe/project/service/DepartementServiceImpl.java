package com.pfe.project.service;

import com.pfe.project.Exception.EntityAlreadyExistsException;
import com.pfe.project.dao.DepartementDao;
import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;
import com.pfe.project.modeles.Departement;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartementServiceImpl implements DepartementService {

    private final DepartementDao departementDao;
    private final ModelMapper modelMapper;

    public DepartementServiceImpl(DepartementDao departementDao, ModelMapper modelMapper) {
        this.departementDao = departementDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartementResponseDto save(DepartementRequestDto requestDto) {
        Departement departement = modelMapper.map(requestDto, Departement.class);
        Departement savedDepartement = departementDao.save(departement);
        return modelMapper.map(savedDepartement, DepartementResponseDto.class);
    }

    @Override
    public DepartementResponseDto findByNom(String nom) {
        Departement departement = departementDao.findByNom(nom);
        return modelMapper.map(departement, DepartementResponseDto.class);
    }

    @Override
    public DepartementResponseDto update(DepartementRequestDto requestDto, Integer id) {
        Departement departement = departementDao.findById(id)
                .orElseThrow(() -> new EntityAlreadyExistsException("Department not found"));
        modelMapper.map(requestDto, departement);
        departement.setId(id);
        Departement updatedDepartement = departementDao.save(departement);
        return modelMapper.map(updatedDepartement, DepartementResponseDto.class);
    }

    @Override
    public List<DepartementResponseDto> findAll() {
        List<Departement> departments = departementDao.findAll();
        return departments.stream()
                .map(department -> modelMapper.map(department, DepartementResponseDto.class))
                .collect(Collectors.toList());
    }
}
