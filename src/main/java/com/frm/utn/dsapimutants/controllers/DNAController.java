package com.frm.utn.dsapimutants.controllers;

import com.frm.utn.dsapimutants.dto.DNADto;
import com.frm.utn.dsapimutants.services.DNAService;

import com.frm.utn.dsapimutants.verifications.DNAVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/")
    public ResponseEntity<Void> checkDNA(@RequestBody DNADto dna) {
        try {
            DNAVerify.verifyDNA(dna.getDna());
            if (dnaService.verifyDNA(dna.getDna())) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            System.out.println("[!] Error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}