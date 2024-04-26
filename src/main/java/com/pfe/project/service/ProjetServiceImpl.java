package com.pfe.project.service;

import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.ProjetDao;

import com.pfe.project.dto.ProjetRequestDto;
import com.pfe.project.dto.ProjetResponseDto;
import com.pfe.project.modeles.Projet;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Service

public class ProjetServiceImpl implements ProjetService{

    private ProjetDao projetDao;
    private ModelMapper modelMapper;



    @Override
    public ProjetResponseDto save(ProjetRequestDto projetRequestDto) {
        Projet projet = modelMapper.map(projetRequestDto, Projet.class);
        Projet saved = projetDao.save(projet);
        return modelMapper.map(saved, ProjetResponseDto.class);
    }


    @Override
    public ProjetResponseDto findByName(String titre) {
        Projet projet = projetDao.findByNom(titre);
        return modelMapper.map(projet, ProjetResponseDto.class);
    }

    @Override
    public ProjetResponseDto update(ProjetRequestDto projetRequestDto, String titre) throws NotFoundException{
        Optional<Projet> projetfound= Optional.ofNullable(projetDao.findByNom(titre));
       if (projetfound.isPresent()){
           Projet projet=modelMapper.map(projetRequestDto,Projet.class);
           projet.setTitre(titre);
           Projet update =projetDao.save(projet);
           return modelMapper.map(update, ProjetResponseDto.class);
       }else {
           throw new EntityNotFoundException("Projet not found ");
       }
    }

    @Override
    public void delete(String titre) {
        projetDao.deleteByName(titre);


    }

    @Override
    public List<ProjetResponseDto> findAll() {
        return projetDao.findAll()
                .stream().map(element -> modelMapper.map(element, ProjetResponseDto.class))
                .collect(Collectors.toList());

    }
}



