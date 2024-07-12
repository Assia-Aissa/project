package com.pfe.project.service;

import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.EtudiantDao;
import com.pfe.project.dao.GroupeDao;
import com.pfe.project.dto.DepartementResponseDto;
import com.pfe.project.dto.GroupeRequestDto;
import com.pfe.project.dto.GroupeResponseDto;
import com.pfe.project.dto.ProfesseurResponseDto;
import com.pfe.project.modeles.Etudiant;
import com.pfe.project.modeles.Groupe;
import com.pfe.project.modeles.Professeur;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupeServiceImpl implements GroupeService {
    @Autowired
    private GroupeDao groupeDao;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private EtudiantDao etudiantDao;

    public GroupeServiceImpl(GroupeDao groupeDao, ModelMapper modelMapper ,EtudiantDao etudiantDao) {
        this.groupeDao = groupeDao;
        this.modelMapper = modelMapper;
        this.etudiantDao = etudiantDao;
    }
    @Override
    public GroupeResponseDto save(GroupeRequestDto groupeRequestDto) {
        Groupe groupe = modelMapper.map(groupeRequestDto, Groupe.class);

        // Fetch the students by their IDs and set them to the group
        List<Etudiant> etudiants = groupeRequestDto.getEtudiantIds().stream()
                .map(etudiantDao::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        groupe.setEtudiants(etudiants);
        groupeDao.save(groupe);

        // Create the response DTO
        GroupeResponseDto responseDto = modelMapper.map(groupe, GroupeResponseDto.class);
        // Set names of the students in the response DTO
        List<String> etudiantNames = etudiants.stream()
                .map(e -> e.getNom() + " " + e.getEtprenom())
                .collect(Collectors.toList());
        responseDto.setEtudiantNames(etudiantNames);

        return responseDto;
    }



    @Override
    public GroupeResponseDto findById(Integer id) {
        Groupe groupe = groupeDao.findById(id).orElseThrow(() -> new RuntimeException("Groupe not found"));
        return modelMapper.map(groupe, GroupeResponseDto.class);
    }


    @Override
    public List<GroupeResponseDto> findAll() {
          return groupeDao.findAll().stream().map(g -> modelMapper.map(g, GroupeResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public GroupeResponseDto findByName(String nom) {
        Groupe groupe = groupeDao.findByNom(nom);
        return modelMapper.map(groupe, GroupeResponseDto.class);
    }

    @Override
    public GroupeResponseDto update(GroupeRequestDto groupeRequestDto, Integer id) {
        Optional<Groupe> groupefound = groupeDao.findById(id);
        if (groupefound.isPresent()) {
            Groupe groupe = groupefound.get();
            modelMapper.map(groupeRequestDto, groupe);
            groupe.setId(id);
            Groupe update = groupeDao.save(groupe);
            return modelMapper.map(update, GroupeResponseDto.class);
        } else {
            throw new EntityNotFoundException("Groupe not Found");
        }
    }

    @Override
    public void delete(Integer id) {
        groupeDao.deleteById(id);
    }



   /* public List<GroupeResponseDto> findAll() {
        List<Groupe> groupes = groupeDao.findAll();
        List<GroupeResponseDto> responseDtos = new ArrayList<>();

        // Iterate through each group
        for (Groupe groupe : groupes) {
            // Get the list of etudiant IDs associated with the group
            List<Integer> etudiantIds = groupe.getEtudiants().stream()
                    .map(Etudiant::getId)
                    .collect(Collectors.toList());

            // Get the list of etudiant names associated with the etudiant IDs
            List<String> etudiantNames = etudiantIds.stream()
                    .map(etudiantDao::findById) // Assuming etudiantDao.findById() fetches etudiant by ID
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .map(etudiant -> etudiant.getNom() + " " + etudiant.getEtprenom())
                    .collect(Collectors.toList());

            // Create a GroupeResponseDto object and set the etudiantNames field
            GroupeResponseDto responseDto = modelMapper.map(groupe, GroupeResponseDto.class);
            responseDto.setEtudiantNames(etudiantNames);

            // Add the responseDto to the list
            responseDtos.add(responseDto);
        }

        return responseDtos;
    }*/

}
