package com.pfe.project.service;

import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.EtudiantDao;
import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;
import com.pfe.project.modeles.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Data

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDao etudiantDao ;
    private ModelMapper modelMapper ;

    public EtudiantServiceImpl(EtudiantDao etudiantDao, ModelMapper modelMapper) {
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
    public EtudiantResponseDto findById(Integer id) {
        Etudiant etudiant =etudiantDao.findById(id).orElseThrow(()-> new EntityNotFoundException("Etudiant not found"));
        return modelMapper.map(etudiant, EtudiantResponseDto.class);
    }

    @Override
    public EtudiantResponseDto findByNom(String nom) {
        Etudiant etudiant =etudiantDao.findByNom(nom);
        return modelMapper.map(etudiant, EtudiantResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
       etudiantDao.deleteById(id);

    }

    @Override
    public EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer id) {
        Optional<Etudiant> etudiantOptional=etudiantDao.findById(id);
        if(etudiantOptional.isPresent()){
            Etudiant etudiant=modelMapper.map(etudiantRequestDto,Etudiant.class);
            etudiant.setCodeApogee(id);
            Etudiant update = etudiantDao.save(etudiant);
            return modelMapper.map(update,EtudiantResponseDto.class);
        }else{
            throw new EntityNotFoundException("Etudient n'exist pas");
        }
    }

    @Override
    public List<EtudiantResponseDto> findAll() {
        return etudiantDao.findAll()
                .stream().map(el->modelMapper.map(el,EtudiantResponseDto.class))
                .collect(Collectors.toList());
    }
}
