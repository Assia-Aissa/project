package com.pfe.project.service;

import com.pfe.project.dao.EtudiantDao;
import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;
import com.pfe.project.modeles.Etudiant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantDao etudiantDao ;
    private ModelMapper modelMapper ;


    public EtudiantServiceImpl(EtudiantDao etudiantDao,ModelMapper modelMapper ) {
        this.etudiantDao = etudiantDao;
        this.modelMapper = modelMapper;
    }




    @Override
    public EtudiantResponseDto save(EtudiantRequestDto etudiantRequestDto) {
        Etudiant etudiant = modelMapper.map(etudiantRequestDto, Etudiant.class);
        Etudiant saved = etudiantDao.save(etudiant);
        return modelMapper.map(saved, EtudiantResponseDto.class);
    }

    @Override
    public EtudiantResponseDto findById(Integer CodeApogee) {
        Etudiant etudiant =etudiantDao.findById(CodeApogee).orElseThrow(()-> new RuntimeException("Etudiant not found"));
        return modelMapper.map(etudiant, EtudiantResponseDto.class);
    }

    @Override
    public EtudiantResponseDto findByNom(String etnom) {
        Etudiant etudiant =etudiantDao.findByNom(etnom);
        return modelMapper.map(etudiant, EtudiantResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
       etudiantDao.deleteById(id);

    }

    @Override
    public EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer id) {
        return null;
    }
}
