package com.pfe.project.service;

import com.pfe.project.dao.ProfesseurDao;
import com.pfe.project.dto.ProfesseurRequestDto;
import com.pfe.project.dto.ProfesseurResponseDto;
import com.pfe.project.modeles.Professeur;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesseurServiceImp implements ProfesseurService {

    private final ProfesseurDao professeurDao;
    private final ModelMapper modelMapper;

    @Override
    public ProfesseurResponseDto save(ProfesseurRequestDto professeurRequestDto) {
        Professeur professeur = modelMapper.map(professeurRequestDto, Professeur.class);
        Professeur saved = professeurDao.save(professeur);
        return modelMapper.map(saved, ProfesseurResponseDto.class);
    }

    @Override
    public ProfesseurResponseDto findById(Integer identifier) {
        Professeur professeur = professeurDao.findById(identifier).orElseThrow(
                () -> new RuntimeException("Professeur not found"));
        return modelMapper.map(professeur, ProfesseurResponseDto.class);
    }

    @Override
    public ProfesseurResponseDto findByNom(String nom) {
        Professeur professeur = professeurDao.findByNom(nom);
        return modelMapper.map(professeur, ProfesseurResponseDto.class);
    }


    @Override
    public ProfesseurResponseDto update(ProfesseurRequestDto professeurRequestDto, Integer identifier) {
        Optional<Professeur> professeurFound = professeurDao.findById(identifier);
        if (professeurFound.isPresent()) {
            Professeur professeur = professeurFound.get();
            modelMapper.map(professeurRequestDto, professeur);
            Professeur updated = professeurDao.save(professeur);
            return modelMapper.map(updated, ProfesseurResponseDto.class);
        } else {
            throw new RuntimeException("Professeur not found");
        }
    }


    @Override
    public void delete(Integer identifier) {
        professeurDao.deleteById(identifier);
    }

    @Override
    public List<ProfesseurResponseDto> findAll() {
        return professeurDao.findAll().stream().map(element -> modelMapper.map(element, ProfesseurResponseDto.class)).collect(Collectors.toList());
    }
}
