package com.pfe.project.controllers;

import com.pfe.project.dto.AdminRequestDto;
import com.pfe.project.dto.AdminResponseDto;
import com.pfe.project.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;



    @PostMapping("/add")
    public ResponseEntity<AdminResponseDto> save(@Valid @RequestBody AdminRequestDto adminRequestDto) {
        AdminResponseDto adminResponseDto = adminService.save(adminRequestDto);
        return new ResponseEntity<>(adminResponseDto, HttpStatus.CREATED);
    }
    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminResponseDto> findById(@PathVariable("id") Integer id) {
        AdminResponseDto adminRespnseDto = adminService.findById(id);
        return ResponseEntity.ok(adminRespnseDto);
    }


   /* @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<AdminResponseDto> update(@Valid @RequestBody AdminRequestDto adminRequestDto,
                                                   @PathVariable("id") Integer id)
            throws ChangeSetPersister.NotFoundException {
        AdminResponseDto adminResponseDto = adminService.update(adminRequestDto, id);
        return ResponseEntity.accepted().body(adminResponseDto);
    }





}
