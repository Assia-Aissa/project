package com.pfe.project.service;


import com.pfe.project.Exception.EntityAlreadyExistsException;
import com.pfe.project.dao.DepartementDao;
import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;
import com.pfe.project.modeles.Departement;
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
@Service
public class DepartementServiceImpl implements  DepartementService {

    private DepartementDao departementDao;
    private ModelMapper modelMapper;




    @Override
    public DepartementResponseDto save(DepartementRequestDto departementRequestDto) {
        Departement departement =modelMapper.map(departementRequestDto, Departement.class);
        Departement saved=departementDao.save(departement);
        return  modelMapper.map(saved,DepartementResponseDto.class);
    }



    @Override
    public DepartementResponseDto findByName(String nom) {
        Departement departement= departementDao.findByName(nom);
        return  modelMapper.map(departement,DepartementResponseDto.class);
    }

    @Override
    public DepartementResponseDto update(DepartementRequestDto departementRequestDto, String nom) {
        Optional<Departement>departementOptional =Optional.ofNullable(departementDao.findByName(nom));
        if (departementOptional.isPresent()){
            Departement departement =departementOptional.get();
            modelMapper.map(departementRequestDto,departement);
            departement.setNom("nom");
            Departement update=departementDao.save(departement);
            return  modelMapper.map(update,DepartementResponseDto.class);
        }else {
            throw new EntityAlreadyExistsException("Département not found ");
        }

    }

    @Override
    public List<DepartementResponseDto> findAll() {
        return departementDao.findAll().stream().map(e->modelMapper.map(e,DepartementResponseDto.class))
                .collect(Collectors.toList());
    }
}