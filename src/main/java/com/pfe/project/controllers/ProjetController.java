package com.pfe.project.controllers;


import com.pfe.project.dto.ProjetRequestDto;
import com.pfe.project.dto.ProjetResponseDto;
import com.pfe.project.service.ProjetService;
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
@RequestMapping ("/Projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;


    @GetMapping("/projet")
    public ResponseEntity<List<ProjetResponseDto>> getProjets(){

        return new ResponseEntity<>(projetService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public  ResponseEntity<ProjetResponseDto> save(@Valid @RequestBody ProjetRequestDto projetRequestDto){
        ProjetResponseDto projetResponseDto = projetService.save(projetRequestDto);
        return new ResponseEntity<>(projetResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/nom/{titre}")
    public ResponseEntity<?> findByName(@PathVariable() String nom){
        ProjetResponseDto projetResponseDto =projetService.findByNom(nom);
        return ResponseEntity.ok(projetResponseDto);
    }

    @DeleteMapping("/nom/ {titre}")
    public ResponseEntity<?> delete(@PathVariable()  String titre){
        projetService.delete(titre);
        return  ResponseEntity.noContent().build();
    }


    public ResponseEntity<ProjetResponseDto> update(@Valid @RequestBody() ProjetRequestDto projetRequestDto , @PathVariable String titre) throws NotFoundException {
        ProjetResponseDto projetResponseDto = projetService.update(projetRequestDto , titre);
        return ResponseEntity.accepted().body(projetResponseDto);
    }


}
