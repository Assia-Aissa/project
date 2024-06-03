package com.pfe.project.controllers;

import com.pfe.project.dto.AdminRequestDto;
import com.pfe.project.dto.AdminResponseDto;
import com.pfe.project.dto.EncadrantRequestDto;
import com.pfe.project.dto.EncadrantResponseDto;
import com.pfe.project.service.EncadrantService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/encadrant")
public class EncadrantController {

    @Autowired
    private EncadrantService encadrantService;

    @GetMapping("/info")
    public ResponseEntity<List<EncadrantResponseDto>> getEncadrants() {
        return new ResponseEntity<>(encadrantService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EncadrantResponseDto> save(@Valid @RequestBody EncadrantRequestDto encadrantRequestDto) {
        EncadrantResponseDto encadrantResponseDto = encadrantService.save(encadrantRequestDto);
        return new ResponseEntity<>(encadrantResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{identifier}")
    public ResponseEntity<EncadrantResponseDto> findById(@PathVariable("identifier") Integer identifier) {
        EncadrantResponseDto encadrantResponseDto = encadrantService.findById(identifier);
        return ResponseEntity.ok(encadrantResponseDto);
    }

    @PutMapping("/id/{identifier}")
    public ResponseEntity<EncadrantResponseDto> update(@Valid @RequestBody EncadrantRequestDto encadrantRequestDto, @PathVariable("identifier") Integer identifier) {
        EncadrantResponseDto encadrantResponseDto = encadrantService.update(encadrantRequestDto, identifier);
        return ResponseEntity.accepted().body(encadrantResponseDto);
    }

    @DeleteMapping("/delete/id/{identifier}")
    public ResponseEntity<?> delete(@PathVariable("identifier") Integer identifier) {
        encadrantService.delete(identifier);
        return ResponseEntity.noContent().build();
    }
}
