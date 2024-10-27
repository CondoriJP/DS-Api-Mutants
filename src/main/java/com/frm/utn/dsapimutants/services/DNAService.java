package com.frm.utn.dsapimutants.services;

import com.frm.utn.dsapimutants.repositories.DNARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DNAService {
    private final DNARepository dnaRepository;

    @Autowired
    public DNAService(DNARepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }
}