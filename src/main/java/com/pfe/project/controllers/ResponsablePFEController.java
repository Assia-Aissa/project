package com.pfe.project.controllers;

import com.pfe.project.dto.ResponsablePFERequestDto;
import com.pfe.project.dto.ResponsablePFEResponseDto;
import com.pfe.project.service.ResponsablePFEService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/responsable")

public class ResponsablePFEController {
    @Autowired
    private ResponsablePFEService responsablePFEService;

    @GetMapping("/info")
    public ResponseEntity<List<ResponsablePFEResponseDto>> getResponsables() {
        return new ResponseEntity<>(responsablePFEService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponsablePFEResponseDto> save(@Valid @RequestBody ResponsablePFERequestDto responsablePFERequestDto) {
        ResponsablePFEResponseDto responsablePFEResponseDto = responsablePFEService.save(responsablePFERequestDto);
        return new ResponseEntity<>(responsablePFEResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{identifier}")
    public ResponseEntity<ResponsablePFEResponseDto> findById(@PathVariable("identifier") Integer identifier) {
        ResponsablePFEResponseDto responsablePFEResponseDto = responsablePFEService.findById(identifier);
        return ResponseEntity.ok(responsablePFEResponseDto);
    }

    @PutMapping("/id/{identifier}")
    public ResponseEntity<ResponsablePFEResponseDto> update(@Valid @RequestBody ResponsablePFERequestDto responsablePFERequestDto, @PathVariable("identifier") Integer identifier) {
        ResponsablePFEResponseDto responsablePFEResponseDto = responsablePFEService.update(responsablePFERequestDto, identifier);
        return ResponseEntity.accepted().body(responsablePFEResponseDto);
    }

    @DeleteMapping("/delete/id/{identifier}")
    public ResponseEntity<?> delete(@PathVariable("identifier") Integer identifier) {
        responsablePFEService.delete(identifier);
        return ResponseEntity.noContent().build();
    }
}
