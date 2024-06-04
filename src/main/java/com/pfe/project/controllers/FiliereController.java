package com.pfe.project.controllers;

import com.pfe.project.dto.FiliereRequestDto;
import com.pfe.project.dto.FiliereResponseDto;
import com.pfe.project.service.FiliereService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/filieres")
public class FiliereController {

    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<FiliereResponseDto>> getFilieres() {
        return new ResponseEntity<>(filiereService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/filiere")
    public ResponseEntity<FiliereResponseDto> save(@Valid @RequestBody FiliereRequestDto filiereRequestDto) {
        FiliereResponseDto filiereResponseDto = filiereService.save(filiereRequestDto);
        return new ResponseEntity<>(filiereResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/filiere/{nom}")
    public ResponseEntity<FiliereResponseDto> findByFnom(@PathVariable("nom") String nom) {
        FiliereResponseDto filiereResponseDto = filiereService.findByNom(nom);
        return ResponseEntity.ok(filiereResponseDto);
    }

    @GetMapping("/filiere/{idF}")
    public ResponseEntity<FiliereResponseDto> findById(@PathVariable("idF") Integer idF) {
        FiliereResponseDto filiereResponseDto = filiereService.findById(idF);
        return ResponseEntity.ok(filiereResponseDto);
    }

    @DeleteMapping("/NoFiliere/{idF}")
    public ResponseEntity<?> delete(@PathVariable Integer idF) {
        filiereService.delete(idF);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/filiere/{idF}")
    public ResponseEntity<FiliereResponseDto> update(@Valid @RequestBody FiliereRequestDto filiereRequestDto, @PathVariable Integer idF) {
        FiliereResponseDto filiereResponseDto = filiereService.update(filiereRequestDto, idF);
        return ResponseEntity.accepted().body(filiereResponseDto);
    }
}
