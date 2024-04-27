package com.pfe.project.service;

import com.pfe.project.dao.ProfesseurDao;
import com.pfe.project.dto.ProfesseurRequestDto;
import com.pfe.project.dto.ProfesseurResponseDto;
import com.pfe.project.modeles.Professeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class ProfesseurServiceImp implements ProfesseurService{

    @Autowired
    private ProfesseurDao professeurDao;
    private ModelMapper modelMapper;

    @Override
    //create professor
    public ProfesseurResponseDto save(ProfesseurRequestDto professeurRequestDto){
        Professeur professeur =modelMapper.map(professeurRequestDto,Professeur.class);
        Professeur saved=professeurDao.save(professeur);
        return modelMapper.map(saved,ProfesseurResponseDto.class);
    }

    @Override
    public ProfesseurResponseDto findById(Integer identifier) {
        Professeur professeur = professeurDao.findById(identifier).orElseThrow(
                ()->new RuntimeException("Professeur not found"));
                return modelMapper.map(professeur,ProfesseurResponseDto.class);
    }

    @Override
    public ProfesseurResponseDto findByNom(String nom) {
        Professeur professeur =professeurDao.findByNom(nom);
        return modelMapper.map(professeur ,ProfesseurResponseDto.class);
    }

    @Override
    public ProfesseurResponseDto update(ProfesseurRequestDto professeurRequestDto, Integer identifier) {
        Optional<Professeur> professeurfound= professeurDao.findById(identifier);
        if(professeurfound.isPresent()){
            Professeur professeur=professeurfound.get();
            modelMapper.map(professeurRequestDto,professeur);
            professeur.SetIdentifier(identifier);
            Professeur updated = professeurDao.save(professeur);
            return modelMapper.map(updated,ProfesseurResponseDto.class);
        }else{
            //exception
            return null;
        }

    }

    @Override
    public void delete(Integer identifier) {
        professeurDao.deleteById(identifier);

    }

    @Override
    public List<ProfesseurResponseDto> findAll() {
        return professeurDao.findAll().stream().map(element ->modelMapper.map(element,ProfesseurResponseDto.class)).collect(Collectors.toList());
    }


}
