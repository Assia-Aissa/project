package com.pfe.project.controllers;

import com.pfe.project.dto.EncadrantRequestDto;
import com.pfe.project.dto.EncadrantResponseDto;
import com.pfe.project.service.EncadrantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encadrant")
@RequiredArgsConstructor
public class EncadrantController {

    private final EncadrantService encadrantService;

    @GetMapping("/info")
    public ResponseEntity<List<EncadrantResponseDto>> getEncadrants() {
        List<EncadrantResponseDto> encadrants = encadrantService.findAll();
        return new ResponseEntity<>(encadrants, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EncadrantResponseDto> save(@Valid @RequestBody EncadrantRequestDto encadrantRequestDto) {
        EncadrantResponseDto encadrantResponseDto = encadrantService.save(encadrantRequestDto);
        return new ResponseEntity<>(encadrantResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EncadrantResponseDto> findById(@PathVariable("id") Integer id) {
        EncadrantResponseDto encadrantResponseDto = encadrantService.findById(id);
        return ResponseEntity.ok(encadrantResponseDto);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<EncadrantResponseDto> update(@Valid @RequestBody EncadrantRequestDto encadrantRequestDto, @PathVariable("id") Integer id) {
        EncadrantResponseDto encadrantResponseDto = encadrantService.update(encadrantRequestDto, id);
        return ResponseEntity.accepted().body(encadrantResponseDto);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        encadrantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
