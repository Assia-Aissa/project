package com.pfe.project.controllers;

import com.pfe.project.dto.ProjetRequestDto;
import com.pfe.project.dto.ProjetResponseDto;
import com.pfe.project.service.ProjetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/Projets")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    @GetMapping("/projet")
    public ResponseEntity<List<ProjetResponseDto>> getProjets() {
        return new ResponseEntity<>(projetService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProjetResponseDto> save(@Valid @RequestBody ProjetRequestDto projetRequestDto) {
        ProjetResponseDto projetResponseDto = projetService.save(projetRequestDto);
        return new ResponseEntity<>(projetResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/nom/{titre}")
    public ResponseEntity<ProjetResponseDto> findByName(@PathVariable String titre) {
        ProjetResponseDto projetResponseDto = projetService.findByNom(titre);
        return ResponseEntity.ok(projetResponseDto);
    }

    @DeleteMapping("/nom/{titre}")
    public ResponseEntity<Void> delete(@PathVariable String titre) {
        projetService.delete(titre);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{titre}")
    public ResponseEntity<ProjetResponseDto> update(@Valid @RequestBody ProjetRequestDto projetRequestDto, @PathVariable String titre) throws ChangeSetPersister.NotFoundException {
        ProjetResponseDto projetResponseDto = projetService.update(projetRequestDto, titre);
        return ResponseEntity.accepted().body(projetResponseDto);
    }
}
