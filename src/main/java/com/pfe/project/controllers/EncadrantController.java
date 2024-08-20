package com.pfe.project.controllers;

import com.pfe.project.dto.*;
import com.pfe.project.modeles.Groupe;
import com.pfe.project.service.EncadrantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @PostMapping("/assign-group")
    public ResponseEntity<AssignEncadrantResponseDto> assignEncadrantToGroup(@RequestBody AssignEncadrantDto assignEncadrantDto) {
        AssignEncadrantResponseDto response = encadrantService.assignEncadrantToGroup(assignEncadrantDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/available-groups")
    public ResponseEntity<?> getGroupsWithoutEncadrant() {
        List<Groupe> groups = encadrantService.findGroupsWithoutEncadrant();
        if (groups.isEmpty()) {
            return new ResponseEntity<>("No groups available for assignment", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }
}
