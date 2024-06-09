package com.pfe.project.service;

import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.DepartementDao;
import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;
import com.pfe.project.modeles.Departement;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements DepartementService {

    private final DepartementDao departementDao;
    private final ModelMapper modelMapper;

    @Override
    public DepartementResponseDto save(DepartementRequestDto departementRequestDto) {
        Departement departement = modelMapper.map(departementRequestDto, Departement.class);
        System.out.println("Mapped Departement: " + departement);
        Departement saved = departementDao.save(departement);
        System.out.println("Saved Departement: " + saved);
        return modelMapper.map(saved, DepartementResponseDto.class);
    }


    @Override
    public List<DepartementResponseDto> findAll() {
        return departementDao.findAll().stream()
                .map(element -> modelMapper.map(element, DepartementResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartementResponseDto findById(Integer id) {
        Departement departement = departementDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found"));
        return modelMapper.map(departement, DepartementResponseDto.class);
    }

    @Override
    public DepartementResponseDto update(DepartementRequestDto departementRequestDto, Integer id) {
        Optional<Departement> departementOptional = departementDao.findById(id);
        if (departementOptional.isPresent()) {
            Departement departement = departementOptional.get();
            modelMapper.map(departementRequestDto, departement);
            Departement updated = departementDao.save(departement);
            return modelMapper.map(updated, DepartementResponseDto.class);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void delete(Integer id) {
        departementDao.deleteById(id);
    }
}
