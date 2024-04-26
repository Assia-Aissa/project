package com.pfe.project.service;

import com.pfe.project.Exception.EntityAlreadyExistsException;
import com.pfe.project.dao.FiliereDao;
import com.pfe.project.dto.FiliereRequestDto;
import com.pfe.project.dto.FiliereResponseDto;
import com.pfe.project.modeles.Filiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class FiliereServiceImp implements FiliereService {
    private FiliereDao filiereDao;
    private ModelMapper modelMapper;



    @Override
    public FiliereResponseDto save(FiliereRequestDto filiereRequestDto) {
        Filiere filiere = modelMapper.map(filiereRequestDto,Filiere.class);
        Filiere saved=filiereDao.save(filiere);
        return modelMapper.map(saved,FiliereResponseDto.class);
    }



    @Override
    public FiliereResponseDto findByNom(String nom) {
      Filiere filiere= filiereDao.findByNom(nom);
      return modelMapper.map(filiere,FiliereResponseDto.class);

    }

    @Override
   /* public void delete(String fnom) {
        filiereDao.deleteByNom(fnom);

    }*/
    public void delete(String nom){
        Filiere filiere= filiereDao.findByNom(nom);
        filiereDao.delete(filiere);
    }


    @Override
    public FiliereResponseDto update(FiliereRequestDto filiereRequestDto,String nom) {
       Optional< Filiere>filiereOptional = Optional.ofNullable(filiereDao.findByNom(nom));
        if(filiereOptional.isPresent()){
            Filiere filiere =filiereOptional.get();
            modelMapper.map(filiereRequestDto,filiere);
            filiere.setNom("nom");
            Filiere updated=filiereDao.save(filiere);
            return modelMapper.map(updated,FiliereResponseDto.class);}
          else {
            throw new EntityAlreadyExistsException();
            }
    }
    @Override
    public List<FiliereResponseDto> findAll() {
        return filiereDao.findAll().stream().map(e->modelMapper.map(e,FiliereResponseDto.class))
                .collect(Collectors.toList());
    }


}
