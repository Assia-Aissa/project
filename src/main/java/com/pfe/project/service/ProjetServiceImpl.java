package com.pfe.project.service;

import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.ProjetDao;

import com.pfe.project.dto.ProjetRequestDto;
import com.pfe.project.dto.ProjetResponseDto;
import com.pfe.project.modeles.Projet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service()

public class ProjetServiceImpl implements ProjetService{
    @Autowired
    private ProjetDao projetDao;
    private ModelMapper modelMapper;



    @Override
    public ProjetResponseDto save(ProjetRequestDto projetRequestDto) {
        Projet projet = modelMapper.map(projetRequestDto, Projet.class);
        Projet saved = projetDao.save(projet);
        return modelMapper.map(saved, ProjetResponseDto.class);
    }


    @Override
    public ProjetResponseDto findByNom(String nom) {
        Projet projet = projetDao.findByNom(nom);
        return modelMapper.map(projet, ProjetResponseDto.class);
    }

    @Override
    public ProjetResponseDto update(ProjetRequestDto projetRequestDto, String nom) throws NotFoundException{
        Optional<Projet> projetfound= Optional.ofNullable(projetDao.findByNom(nom));
       if (projetfound.isPresent()){
           Projet projet=modelMapper.map(projetRequestDto,Projet.class);
           projet.setNom(nom);
           Projet update =projetDao.save(projet);
           return modelMapper.map(update, ProjetResponseDto.class);
       }else {
           throw new EntityNotFoundException("Projet not found ");
       }
    }

    @Override
    public void delete(String nom) {
        projetDao.deleteByNom(nom);


    }

    @Override
    public List<ProjetResponseDto> findAll() {
        return projetDao.findAll()
                .stream().map(element -> modelMapper.map(element, ProjetResponseDto.class))
                .collect(Collectors.toList());

    }
}



