package com.pfe.project.controllers;

import com.pfe.project.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EtudiantController {

    @Autowired
    @Qualifier("impl2")
    private EtudiantService etudiantService;
}
