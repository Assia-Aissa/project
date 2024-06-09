package com.pfe.project.controllers;

import com.pfe.project.dto.DepartementRequestDto;
import com.pfe.project.dto.DepartementResponseDto;
import com.pfe.project.service.DepartementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/departements")
public class DepartementController {

    private final DepartementService departementService;

    @GetMapping("/getdept/all")
    public ResponseEntity<List<DepartementResponseDto>> getAllDepartements() {
        return new ResponseEntity<>(departementService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addDept")
    public ResponseEntity<DepartementResponseDto> save(@RequestBody @Valid DepartementRequestDto departementRequestDto) {
        DepartementResponseDto departementResponseDto = departementService.save(departementRequestDto);
        return new ResponseEntity<>(departementResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/dept/{id}")
    public ResponseEntity<DepartementResponseDto> getDepartementById(@PathVariable("id") Integer id) {
        DepartementResponseDto departementResponseDto = departementService.findById(id);
        return ResponseEntity.ok(departementResponseDto);
    }

    @PutMapping("/updateDept/{id}")
    public ResponseEntity<DepartementResponseDto> update(@Valid @RequestBody DepartementRequestDto departementRequestDto, @PathVariable("id") Integer id) throws ChangeSetPersister.NotFoundException {
        DepartementResponseDto departementResponseDto = departementService.update(departementRequestDto, id);
        return ResponseEntity.accepted().body(departementResponseDto);
    }
}
