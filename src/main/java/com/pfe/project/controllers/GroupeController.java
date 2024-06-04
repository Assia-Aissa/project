package com.pfe.project.controllers;

import com.pfe.project.dto.GroupeRequestDto;
import com.pfe.project.dto.GroupeResponseDto;
import com.pfe.project.service.GroupeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Groupes")
public class GroupeController {

    private final GroupeService groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @PostMapping("/groupe")
    public ResponseEntity<GroupeResponseDto> save(@Valid @RequestBody GroupeRequestDto groupeRequestDto) {
        GroupeResponseDto groupeResponseDto = groupeService.save(groupeRequestDto);
        return new ResponseEntity<>(groupeResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<GroupeResponseDto>> getGroupes() {
        return new ResponseEntity<>(groupeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/groupe/{id}")
    public ResponseEntity<GroupeResponseDto> findById(@PathVariable("id") Integer id) {
        GroupeResponseDto groupeResponseDto = groupeService.findById(id);
        return ResponseEntity.ok(groupeResponseDto);
    }

    @GetMapping("/groupe/{nom}")
    public ResponseEntity<GroupeResponseDto> findByName(@PathVariable("nom") String nom) {
        GroupeResponseDto groupeResponseDto = groupeService.findByName(nom);
        return ResponseEntity.ok(groupeResponseDto);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        groupeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<GroupeResponseDto> update(@Valid @RequestBody GroupeRequestDto groupeRequestDto, @PathVariable("id") Integer id) {
        GroupeResponseDto groupeResponseDto = groupeService.update(groupeRequestDto, id);
        return ResponseEntity.accepted().body(groupeResponseDto);
    }
}
