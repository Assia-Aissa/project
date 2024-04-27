package com.pfe.project.controllers;

import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;
import com.pfe.project.service.DepartementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping("/departement")
    public ResponseEntity<List<DepartementResponseDto>> getDepartements(){

         return  new ResponseEntity<>(departementService.findAll() , HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<DepartementResponseDto> save(@Valid @RequestBody DepartementRequestDto departementRequestDto){

         DepartementResponseDto departementResponseDto = departementService.save(departementRequestDto);
         return  new ResponseEntity<>(departementResponseDto, HttpStatus.CREATED);

    }


    @GetMapping("/departement/{nom}")
    public  ResponseEntity<?> findByName(@PathVariable("nom") String nom ){
        DepartementResponseDto departementResponseDto ;
        departementResponseDto = departementService.findByNom(nom);
        return  ResponseEntity.ok(departementResponseDto);
    }



    public  ResponseEntity<DepartementResponseDto> update(@Valid @RequestBody DepartementRequestDto departementRequestDto,@PathVariable String nom)
              throws NotFoundException{
        DepartementResponseDto departementResponseDto = departementService.update(departementRequestDto,nom );
        return ResponseEntity.accepted().body(departementResponseDto);
    }


}
