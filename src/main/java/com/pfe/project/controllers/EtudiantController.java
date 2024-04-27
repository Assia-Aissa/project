package com.pfe.project.controllers;

import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;
import com.pfe.project.service.EtudiantService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
     private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/etudiant")
    public ResponseEntity<List<EtudiantResponseDto>> getEtudiants() {

        return new ResponseEntity<>(etudiantService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<EtudiantResponseDto> save(@Valid @RequestBody() EtudiantRequestDto etudiantRequestDto){
       EtudiantResponseDto etudiantResponseDto = etudiantService.save(etudiantRequestDto);
       return new ResponseEntity<>(etudiantResponseDto,HttpStatus.CREATED);
    }

    @GetMapping("/id/{codeApogee}")
    public ResponseEntity<EtudiantResponseDto> findById(@PathVariable("codeApogee") Integer codeApogee) {
       EtudiantResponseDto etudiantResponseDto= etudiantService.findById(codeApogee);
       return ResponseEntity.ok(etudiantResponseDto);

    }

    @GetMapping("/nom/{etnom}")
    public ResponseEntity<EtudiantResponseDto> findByNom(@PathVariable("nom") String nom) {
        EtudiantResponseDto etudiantResponseDto =etudiantService.findByNom(nom);
        return ResponseEntity.ok(etudiantResponseDto);
    }

    @DeleteMapping("/id/{codeApogee}")
    public ResponseEntity<?> delete(@PathVariable() Integer codeApogee) {
        etudiantService.delete(codeApogee);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{codeApogee}")
    public ResponseEntity<EtudiantResponseDto> update(@Valid @RequestBody() EtudiantRequestDto etudiantRequestDto,@PathVariable Integer codeApogee) throws NotFoundException {
       EtudiantResponseDto etudiantResponseDto= etudiantService.update(etudiantRequestDto, codeApogee);
       return ResponseEntity.accepted().body(etudiantResponseDto);
    }


}
