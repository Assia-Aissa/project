package com.pfe.project.controllers;


import com.pfe.project.dto.ProfesseurRequestDto;
import com.pfe.project.dto.ProfesseurResponseDto;
import com.pfe.project.service.ProfesseurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class professeurController {
    @Autowired
    private ProfesseurService professeurService;
    public professeurController(ProfesseurService professeurService){
        this.professeurService=professeurService;
    }

    @GetMapping("professeur/info")
    public ResponseEntity<List<ProfesseurResponseDto>> getProfesseur(){

        return new ResponseEntity<>(professeurService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProfesseurResponseDto> save(@Valid @RequestBody()ProfesseurRequestDto professeurRequestDto){
        System.out.println("just see if there is any error or not :)");
        System.out.println("just see if there is any error or not :)");
        ProfesseurResponseDto professeurResponseDto=professeurService.save(professeurRequestDto);
        return new ResponseEntity<>(professeurResponseDto,HttpStatus.CREATED);
    }
    @GetMapping("Prof/{identifier}")
    public ResponseEntity<ProfesseurResponseDto> findById(@PathVariable("identifier") Integer identifier){
        ProfesseurResponseDto professeurResponseDto = professeurService.findById(identifier);
        return ResponseEntity.ok(professeurResponseDto);
    }

    @GetMapping("/professeur/nom/{nom}")
    public ResponseEntity <ProfesseurResponseDto> findByNom(@PathVariable() String nom){
        ProfesseurResponseDto professeurResponseDto =professeurService.findByNom(nom);
        return ResponseEntity.ok(professeurResponseDto);
    }

    @DeleteMapping("/Delete/id/{identifier}")
    public ResponseEntity<?> delete (@PathVariable() Integer identifier){
        professeurService.delete(identifier);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{identifier}")
    public ResponseEntity<ProfesseurResponseDto> update(@Valid @RequestBody() ProfesseurRequestDto professeurRequestDto,@PathVariable("identifier") Integer identifier){
        ProfesseurResponseDto professeurResponseDto = professeurService.update(professeurRequestDto,identifier);
        return ResponseEntity.accepted().body(professeurResponseDto);

    }











}
