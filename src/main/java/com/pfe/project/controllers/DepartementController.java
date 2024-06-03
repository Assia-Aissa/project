package com.pfe.project.controllers;

import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;
import com.pfe.project.service.DepartementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departements")
public class DepartementController {

    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public ResponseEntity<List<DepartementResponseDto>> findAllDepartments() {
        List<DepartementResponseDto> departments = departementService.findAll();
        return ResponseEntity.ok().body(departments);
    }

    @PostMapping("/add")
    public ResponseEntity<DepartementResponseDto> addDepartment(@Valid @RequestBody DepartementRequestDto requestDto) {
        DepartementResponseDto responseDto = departementService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{nom}")
    public ResponseEntity<DepartementResponseDto> findDepartmentByName(@PathVariable("nom") String nom) {
        DepartementResponseDto responseDto = departementService.findByNom(nom);
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartementResponseDto> updateDepartment(@PathVariable("id") Integer id, @Valid @RequestBody DepartementRequestDto requestDto) {
        DepartementResponseDto responseDto = departementService.update(requestDto, id);
        return ResponseEntity.ok().body(responseDto);
    }
}
