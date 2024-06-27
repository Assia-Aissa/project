package com.pfe.project.service;

import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.EtudiantDao;
import com.pfe.project.dao.GroupeDao;
import com.pfe.project.dao.ProjetDao;
import com.pfe.project.dto.*;
import com.pfe.project.modeles.Etudiant;
import com.pfe.project.modeles.Filiere;
import com.pfe.project.modeles.Groupe;
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
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EtudiantDao etudiantDao;

    @Autowired
    private GroupeDao groupeDao;

    public void assignProjectToGroup(AssignProjectDTO assignProjectDTO) {
        // Retrieve the group and project from the database
        Groupe group = groupeDao.findById(assignProjectDTO.getGroupId()).orElseThrow(() -> new EntityNotFoundException("Group not found"));
        Projet project = projetDao.findById(assignProjectDTO.getProjectId()).orElseThrow(() -> new EntityNotFoundException("Project not found"));

        // Assign the project to the group
        group.setProject(project);
        groupeDao.save(group);
    }


    /*  @Override
      public ProjetResponseDto save(ProjetRequestDto projetRequestDto) {
          Projet projet = modelMapper.map(projetRequestDto, Projet.class);
          System.out.println("Mapped projet: " + projet);
          projet.setEtudiants(projetRequestDto.getEtudiantIds().stream()
                  .map(id -> {
                      try {
                          return etudiantDao.findById(id).orElseThrow(() -> new NotFoundException());
                      } catch (NotFoundException e) {
                          throw new RuntimeException(e);
                      }
                  })
                  .collect(Collectors.toList()));
          Projet saved = projetDao.save(projet);
          System.out.println("Saved projet: " + saved);
          return modelMapper.map(saved, ProjetResponseDto.class);
      }

    @Override
    public ProjetResponseDto save(ProjetRequestDto projetRequestDto) {
        Projet projet = modelMapper.map(projetRequestDto, Projet.class);
        System.out.println("Mapped projet: " + projet);
        Projet saved = projetDao.save(projet);
        System.out.println("Saved projet: " + saved);
        return modelMapper.map(saved, ProjetResponseDto.class);
    }*/
    @Override
    public ProjetResponseDto save(ProjetRequestDto projetRequestDto) {
        Projet projet = modelMapper.map(projetRequestDto, Projet.class);
        Projet saved = projetDao.save(projet);
        return modelMapper.map(saved, ProjetResponseDto.class);
    }
    @Override
    public ProjetResponseDto findById(Integer id) {
        Projet projet = projetDao.findById(id).orElseThrow(() -> new RuntimeException("projet not found"));
        return modelMapper.map(projet, ProjetResponseDto.class);
    }

    @Override
    public ProjetResponseDto update(ProjetRequestDto projetRequestDto, Integer id) throws NotFoundException{
        Optional<Projet> projetfound= projetDao.findById(id);
        if (projetfound.isPresent()){
            Projet projet=modelMapper.map(projetRequestDto,Projet.class);
            projet.setId(id);
            Projet update =projetDao.save(projet);
            return modelMapper.map(update, ProjetResponseDto.class);
        }else {
            throw new EntityNotFoundException("Projet not found ");
        }
    }

    @Override
    public void delete(Integer id) {
        projetDao.deleteById(id);


    }

    @Override
    public List<ProjetResponseDto> findAll() {
        return projetDao.findAll()
                .stream().map(element -> modelMapper.map(element, ProjetResponseDto.class))
                .collect(Collectors.toList());

    }
}



