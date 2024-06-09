package com.pfe.project.controllers;

import com.pfe.project.dto.ProfesseurRequestDto;
import com.pfe.project.dto.ProfesseurResponseDto;
import com.pfe.project.service.ProfesseurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/professeur")
@RequiredArgsConstructor
public class professeurController {
    private final ProfesseurService professeurService;

    @GetMapping("/info")
    public ResponseEntity<List<ProfesseurResponseDto>> getProfesseurs() {
        return new ResponseEntity<>(professeurService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProfesseurResponseDto> save(@Valid @RequestBody ProfesseurRequestDto professeurRequestDto) {
        ProfesseurResponseDto professeurResponseDto = professeurService.save(professeurRequestDto);
        return new ResponseEntity<>(professeurResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{identifier}")
    public ResponseEntity<ProfesseurResponseDto> findById(@PathVariable("identifier") Integer identifier) {
        ProfesseurResponseDto professeurResponseDto = professeurService.findById(identifier);
        return ResponseEntity.ok(professeurResponseDto);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ProfesseurResponseDto> findByNom(@PathVariable("nom") String nom) {
        ProfesseurResponseDto professeurResponseDto = professeurService.findByNom(nom);
        return ResponseEntity.ok(professeurResponseDto);
    }

    @DeleteMapping("/delete/id/{identifier}")
    public ResponseEntity<?> delete(@PathVariable("identifier") Integer identifier) {
        professeurService.delete(identifier);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{identifier}")
    public ResponseEntity<ProfesseurResponseDto> update(@Valid @RequestBody ProfesseurRequestDto professeurRequestDto, @PathVariable("identifier") Integer identifier) {
        ProfesseurResponseDto professeurResponseDto = professeurService.update(professeurRequestDto, identifier);
        return ResponseEntity.accepted().body(professeurResponseDto);
    }
}
