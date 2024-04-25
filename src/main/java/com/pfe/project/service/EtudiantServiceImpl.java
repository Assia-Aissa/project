package com.pfe.project.service;

import com.pfe.project.Exception.EntityNotFoundException;
import com.pfe.project.dao.EtudiantDao;
import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;
import com.pfe.project.modeles.Etudiant;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Etudiant etudiant =etudiantDao.findById(CodeApogee).orElseThrow(()-> new EntityNotFoundException("Etudiant not found"));
        return modelMapper.map(etudiant, EtudiantResponseDto.class);
    }

    @Override
    public EtudiantResponseDto findByNom(String nom) {
        Etudiant etudiant =etudiantDao.findBynom(nom);
        return modelMapper.map(etudiant, EtudiantResponseDto.class);
    }

    @Override
    public void delete(Integer CodeApogee) {
       etudiantDao.deleteById(CodeApogee);

    }

    @Override
    public EtudiantResponseDto update(EtudiantRequestDto etudiantRequestDto, Integer codeApogee) throws NotFoundException {
        Optional<Etudiant> etudiantOptional=etudiantDao.findById(codeApogee);
        if(etudiantOptional.isPresent()){
            Etudiant etudiant=modelMapper.map(etudiantRequestDto,Etudiant.class);
            etudiant.setCodeApogee(codeApogee);
            Etudiant update = etudiantDao.save(etudiant);
            return modelMapper.map(update,EtudiantResponseDto.class);
        }else{
            throw new EntityNotFoundException("Etidiant not Found");
        }
    }

    @Override
    public List<EtudiantResponseDto> findAll() {
        return etudiantDao.findAll()
                .stream().map(el->modelMapper.map(el,EtudiantResponseDto.class))
                .collect(Collectors.toList());
    }
}
