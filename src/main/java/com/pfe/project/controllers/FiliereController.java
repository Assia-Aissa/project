package com.pfe.project.controllers;

import com.pfe.project.dto.FiliereRequestDto;
import com.pfe.project.dto.FiliereResponseDto;
import com.pfe.project.service.FiliereService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/filieres")
public class FiliereController {

    private FiliereService filiereService;
    @GetMapping("/list")
    public ResponseEntity<List<FiliereResponseDto>> getFilieres(){
        return new ResponseEntity<>(filiereService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/filiere")
    public ResponseEntity<FiliereResponseDto> save(@Valid @RequestBody FiliereRequestDto filiereRequestDto){
        FiliereResponseDto filiereResponseDto =filiereService.save(filiereRequestDto);
        return new ResponseEntity<>(filiereResponseDto,HttpStatus.CREATED);
    }
    @GetMapping("/filiere/{nom}")
    public ResponseEntity<FiliereResponseDto> findByFnom(@PathVariable("nom") String nom){
        FiliereResponseDto filiereResponseDto;
        filiereResponseDto = filiereService.findByNom(nom);
        return ResponseEntity.ok(filiereResponseDto);
    }

    @DeleteMapping("/NoFiliere/{nom}")
    public ResponseEntity<?> delete (@PathVariable() String nom){
        filiereService.delete(nom);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/filiere/{fnom}")
   public ResponseEntity<FiliereResponseDto> update(@Valid @RequestBody FiliereRequestDto filiereRequestDto,@PathVariable  String nom)
            throws ChangeSetPersister.NotFoundException{
        {
            FiliereResponseDto filiereResponseDto =filiereService.update(filiereRequestDto,nom);
            return ResponseEntity.accepted().body(filiereResponseDto);
        }

    }




}
