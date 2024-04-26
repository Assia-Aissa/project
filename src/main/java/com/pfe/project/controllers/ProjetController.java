package com.pfe.project.controllers;


import com.pfe.project.dto.ProjetRequestDto;
import com.pfe.project.dto.ProjetResponseDto;
import com.pfe.project.service.ProjetService;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Projets")
public class ProjetController {

    private ProjetService projetService;

    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @GetMapping("/projet")
    public ResponseEntity<List<ProjetResponseDto>> getProjet(){

        return new ResponseEntity<>(projetService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/add")
    public  ResponseEntity<ProjetResponseDto> save(@Valid @RequestBody ProjetRequestDto projetRequestDto){
        ProjetResponseDto projetResponseDto = projetService.save(projetRequestDto);
        return new ResponseEntity<>(projetResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/nom/{titre}")
    public ResponseEntity<?> findByName(@PathVariable() String titre){
        ProjetResponseDto projetResponseDto =projetService.findByName(titre);
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
