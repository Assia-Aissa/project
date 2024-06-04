package com.pfe.project.service;

import com.pfe.project.dao.AdminDao;
import com.pfe.project.dto.AdminRequestDto;
import com.pfe.project.dto.AdminResponseDto;
import com.pfe.project.modeles.Administrateur;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService {

    private final AdminDao adminDao;
    private final ModelMapper modelMapper;

    public AdminServiceImp(AdminDao adminDao, ModelMapper modelMapper) {
        this.adminDao = adminDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public AdminResponseDto save(AdminRequestDto adminRequestDto) {
        Administrateur administrateur = modelMapper.map(adminRequestDto, Administrateur.class);
        Administrateur saved = adminDao.save(administrateur);
        return modelMapper.map(saved, AdminResponseDto.class);
    }

    @Override
    public AdminResponseDto findById(Integer id) {
        Administrateur administrateur = adminDao.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return modelMapper.map(administrateur, AdminResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        adminDao.deleteById(id);
    }

    @Override
    public AdminResponseDto update(AdminRequestDto adminRequestDto, Integer id) throws ChangeSetPersister.NotFoundException {
        Optional<Administrateur> administrateurOptional = adminDao.findById(id);
        if (administrateurOptional.isPresent()) {
            Administrateur administrateur = administrateurOptional.get();
            modelMapper.map(adminRequestDto, administrateur);
            administrateur.setId(id);
            Administrateur updated = adminDao.save(administrateur);
            return modelMapper.map(updated, AdminResponseDto.class);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}
