package com.pfe.project.controllers;

import com.pfe.project.dto.AssignProjectDTO;
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


    private ProjetService projetService;

    @GetMapping("/projet")
    public ResponseEntity<List<ProjetResponseDto>> getProjets() {
        return new ResponseEntity<>(projetService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/assign-project")
    public ResponseEntity<String> assignProjectToGroup(@RequestBody AssignProjectDTO assignProjectDTO) {
        projetService.assignProjectToGroup(assignProjectDTO);
        return ResponseEntity.ok("Project assigned to group successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<ProjetResponseDto> save(@RequestBody @Valid ProjetRequestDto projetRequestDto) {
        ProjetResponseDto response = projetService.save(projetRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/nom/{id}")
    public ResponseEntity<ProjetResponseDto> findByName(@PathVariable Integer id ) {
        ProjetResponseDto projetResponseDto = projetService.findById(id);
        return ResponseEntity.ok(projetResponseDto);
    }

    @DeleteMapping("/nom/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        projetService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjetResponseDto> update(@Valid @RequestBody ProjetRequestDto projetRequestDto, @PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        ProjetResponseDto projetResponseDto = projetService.update(projetRequestDto, id);
        return ResponseEntity.accepted().body(projetResponseDto);
    }
}
