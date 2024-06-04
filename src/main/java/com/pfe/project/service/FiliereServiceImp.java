package com.pfe.project.service;

import com.pfe.project.Exception.EntityAlreadyExistsException;
import com.pfe.project.dao.FiliereDao;
import com.pfe.project.dto.FiliereRequestDto;
import com.pfe.project.dto.FiliereResponseDto;
import com.pfe.project.modeles.Filiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class FiliereServiceImp implements FiliereService {
    @Autowired
    private FiliereDao filiereDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FiliereResponseDto save(FiliereRequestDto filiereRequestDto) {
        Filiere filiere = modelMapper.map(filiereRequestDto, Filiere.class);
        Filiere saved = filiereDao.save(filiere);
        return modelMapper.map(saved, FiliereResponseDto.class);
    }

    @Override
    public FiliereResponseDto findById(Integer idF) {
        Filiere filiere = filiereDao.findById(idF)
                .orElseThrow(() -> new RuntimeException("Filiere not found"));
        return modelMapper.map(filiere, FiliereResponseDto.class);
    }

    @Override
    public FiliereResponseDto findByNom(String nom) {
        Filiere filiere = filiereDao.findByNom(nom);
        return modelMapper.map(filiere, FiliereResponseDto.class);
    }

    @Override
    public void delete(Integer idF) {
        filiereDao.deleteById(idF);
    }

    @Override
    public FiliereResponseDto update(FiliereRequestDto filiereRequestDto, Integer idF) {
        Optional<Filiere> filiereOptional = filiereDao.findById(idF);
        if (filiereOptional.isPresent()) {
            Filiere filiere = filiereOptional.get();
            modelMapper.map(filiereRequestDto, filiere);
            filiere.setIdF(idF);
            Filiere updated = filiereDao.save(filiere);
            return modelMapper.map(updated, FiliereResponseDto.class);
        } else {
            throw new EntityAlreadyExistsException();
        }
    }

    @Override
    public List<FiliereResponseDto> findAll() {
        return filiereDao.findAll().stream()
                .map(e -> modelMapper.map(e, FiliereResponseDto.class))
                .collect(Collectors.toList());
    }
}
