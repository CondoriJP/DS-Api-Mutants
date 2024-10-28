package com.frm.utn.dsapimutants.controllers;

import com.frm.utn.dsapimutants.services.DNAService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mutant")
public class DNAController {
    private final DNAService dnaService;

    @Autowired
    public DNAController(DNAService dnaService) {
        this.dnaService = dnaService;
    }
}