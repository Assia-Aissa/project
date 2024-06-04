package com.pfe.project.service;

import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.GroupeDao;
import com.pfe.project.dto.GroupeRequestDto;
import com.pfe.project.dto.GroupeResponseDto;
import com.pfe.project.modeles.Groupe;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupeServiceImpl implements GroupeService {

    private final GroupeDao groupeDao;
    private final ModelMapper modelMapper;

    public GroupeServiceImpl(GroupeDao groupeDao, ModelMapper modelMapper) {
        this.groupeDao = groupeDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public GroupeResponseDto save(GroupeRequestDto groupeRequestDto) {
        Groupe groupe = modelMapper.map(groupeRequestDto, Groupe.class);
        // Set the list of students manually
        groupe.setEtudiantsNames(groupeRequestDto.getEtudiantsNames());
        Groupe saved = groupeDao.save(groupe);
        return modelMapper.map(saved, GroupeResponseDto.class);
    }

    @Override
    public GroupeResponseDto findById(Integer id) {
        Groupe groupe = groupeDao.findById(id).orElseThrow(
                () -> new RuntimeException("Groupe not found"));
        return modelMapper.map(groupe, GroupeResponseDto.class);
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

    @Override
    public List<GroupeResponseDto> findAll() {
        return groupeDao.findAll().stream().map(element -> modelMapper.map(element, GroupeResponseDto.class)).collect(Collectors.toList());
    }
}
