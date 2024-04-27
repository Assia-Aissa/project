package com.pfe.project.controllers;


import com.pfe.project.dto.GroupeRequestDto;
import com.pfe.project.dto.GroupeResponseDto;
import com.pfe.project.service.GroupeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@AllArgsConstructor
@RestController
@RequestMapping("/Groupes")
public class GroupeController {


    private GroupeService groupeService ;

    @GetMapping("/list")
    public ResponseEntity<List<GroupeResponseDto>>  getGroupes(){
        return  new ResponseEntity<>(groupeService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/groupe")
    public  ResponseEntity<GroupeResponseDto> save(@Valid @RequestBody GroupeRequestDto groupeRequestDto){
        GroupeResponseDto groupeResponseDto ;
        groupeResponseDto= groupeService.save(groupeRequestDto);
        return  new ResponseEntity<>(groupeResponseDto,HttpStatus.CREATED);
    }


    @GetMapping("/groupe/{id}")
    public  ResponseEntity<GroupeResponseDto> findById(@PathVariable("id") Integer id){
        GroupeResponseDto groupeResponseDto = groupeService.findById(id);
        return ResponseEntity.ok(groupeResponseDto);

    }

    @GetMapping("/groupe/{noms}")
    public ResponseEntity<GroupeResponseDto> findByNom(@PathVariable("noms") String nom){

        GroupeResponseDto groupeResponseDto =groupeService.findByName(nom);
        return ResponseEntity.ok(groupeResponseDto);
    }



    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Integer id){
        groupeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/id/{id}")
    public  ResponseEntity<GroupeResponseDto> update(@Valid @RequestBody() GroupeRequestDto groupeRequestDto,@PathVariable("id") Integer id){
        GroupeResponseDto groupeResponseDto = groupeService.update(groupeRequestDto,id);
        return ResponseEntity.accepted().body(groupeResponseDto);
    }

}
