package com.pfe.project.controllers;

import com.pfe.project.dto.EtudiantRequestDto;
import com.pfe.project.dto.EtudiantResponseDto;
import com.pfe.project.service.EtudiantService;
import jakarta.validation.Valid;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Data
@CrossOrigin("")
@RestController
@RequestMapping()
public class EtudiantController {


     private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("Etudiant/info")
    public ResponseEntity<List<EtudiantResponseDto>> getEtudiants() {

        return new ResponseEntity<>(etudiantService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<EtudiantResponseDto> save(@Valid @RequestBody() EtudiantRequestDto etudiantRequestDto){
       EtudiantResponseDto etudiantResponseDto = etudiantService.save(etudiantRequestDto);
       return new ResponseEntity<>(etudiantResponseDto,HttpStatus.CREATED);
    }
    @PutMapping("/accept")
    public void acceptStudents(@RequestBody List<Integer> ids) {
        etudiantService.acceptStudents(ids);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<EtudiantResponseDto> findById(@PathVariable("id") Integer id) {
       EtudiantResponseDto etudiantResponseDto= etudiantService.findById(id);
       return ResponseEntity.ok(etudiantResponseDto);

    }

    @GetMapping("/nom/{etnom}")
    public ResponseEntity<EtudiantResponseDto> findByNom(@PathVariable("nom") String nom) {
        EtudiantResponseDto etudiantResponseDto =etudiantService.findByNom(nom);
        return ResponseEntity.ok(etudiantResponseDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        etudiantService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<EtudiantResponseDto> update(@Valid @RequestBody() EtudiantRequestDto etudiantRequestDto,@PathVariable("id") Integer id) throws NotFoundException {
       EtudiantResponseDto etudiantResponseDto= etudiantService.update(etudiantRequestDto, id);
       return ResponseEntity.accepted().body(etudiantResponseDto);
    }


}
