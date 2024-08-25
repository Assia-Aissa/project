package com.pfe.project.service;

import com.pfe.project.Exception.EntityAlreadyExistsException;
import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.EncadrantDao;
import com.pfe.project.dao.GroupeDao;
import com.pfe.project.dto.*;
import com.pfe.project.modeles.Encadrant;
import com.pfe.project.modeles.Groupe;
import com.pfe.project.modeles.Projet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Data
@AllArgsConstructor

@Service
@RequiredArgsConstructor
public class EncadrantServiceImpl implements EncadrantService {
    @Autowired
    private  EncadrantDao encadrantDao;
    @Autowired
    private   ModelMapper modelMapper;

    @Autowired
    private  GroupeDao groupeDao;

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
    @Override
    public AssignEncadrantResponseDto assignEncadrantToGroup(AssignEncadrantDto assignEncadrantDto) {
        // Retrieve the group and encadrant from the database
        Groupe group = groupeDao.findById(assignEncadrantDto.getGroupId())
                .orElseThrow(() -> new EntityNotFoundException("Group not found"));
        Encadrant encadrant = encadrantDao.findById(assignEncadrantDto.getEncadrantId())
                .orElseThrow(() -> new EntityNotFoundException("Encadrant not found"));

        // Assign the group to the encadrant
        encadrant.getGroupes().add(group);
        group.getEncadrants().add(encadrant);

        encadrantDao.save(encadrant);
        groupeDao.save(group);

        // Prepare the response DTO
        return new AssignEncadrantResponseDto(
                encadrant.getIdentifier(),
                encadrant.getNom(),
                encadrant.getEmail(),
                group.getId(),
                group.getNom()
        );
    }


    @Override
    public List<Groupe> findGroupsWithoutEncadrant() {
        return groupeDao.findGroupsWithoutEncadrant();
    }
}