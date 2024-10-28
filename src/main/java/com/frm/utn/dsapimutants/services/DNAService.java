package com.frm.utn.dsapimutants.services;

import com.frm.utn.dsapimutants.entities.DNA;
import com.frm.utn.dsapimutants.repositories.DNARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class DNAService {
    private final DNARepository dnaRepository;

    @Autowired
    public DNAService(DNARepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public boolean verifyDNA(String[] dna){
        Optional<Boolean> dnaDB = dnaRepository.findByDNA(dna);
        if(dnaDB.isPresent()) return dnaDB.get();
        boolean isMutant = isMutant(dna);
        DNA dnaEntity = DNA.builder()
                .dna(dna)
                .isMutant(isMutant)
                .build();
        dnaRepository.save(dnaEntity);
        return isMutant;
    }

    public static boolean isMutant(String[] dna) {
        int n = dna.length;
        if (n < 4) return false;
        String[] busqueda = {"AAAA","CCCC","GGGG","TTTT"};
        StringBuilder vertical;
        int contador = 0;
        for (int i = 0; i < n; i++) {
            contador += Arrays.stream(busqueda).anyMatch(dna[i]::contains) ? 1 : 0;
            vertical = new StringBuilder();
            for (String s : dna) vertical.append(s.charAt(i));
            contador += Arrays.stream(busqueda).anyMatch(vertical.toString()::contains) ? 1 : 0;
            if (i <= n - 4) {
                StringBuilder diag = new StringBuilder();
                StringBuilder diagInv = new StringBuilder();
                for (int k = 0; k < n - i; k++) {
                    diag.append(dna[i + k].charAt(k));
                    diagInv.append(dna[i + k].charAt(n - 1 - k));
                }
                contador += Arrays.stream(busqueda).anyMatch(diag.toString()::contains) ? 1 : 0;
                contador += Arrays.stream(busqueda).anyMatch(diagInv.toString()::contains) ? 1 : 0;
            }
            if (contador >=2) return true;
        }
        return false;
    }
}