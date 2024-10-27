package com.frm.utn.dsapimutants.services;

import com.frm.utn.dsapimutants.repositories.DNARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DNAService {
    private final DNARepository dnaRepository;

    @Autowired
    public DNAService(DNARepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public static boolean isMutant(String[] dna){
        String[] busqueda = {"AAAA","CCCC","GGGG","TTTT"};
        int contador = 0;
        int diagComienzo = dna.length - busqueda[0].length();
        int diagCant = 2 * diagComienzo + 1;
        int diagIni = diagComienzo + 1;
        int diagFin = 0;
        int diagIndiceIni = 0;
        int diagIndice = 0;
        String[] diag = new String[diagCant];
        String[] diagInv = new String[diagCant];
        String vertical = "";

        for (int i = 0; i < dna.length; i++) {
            contador += Arrays.stream(busqueda).anyMatch(dna[i]::contains) ? 1 : 0;

            vertical = "";
            for (int j = 0; j < dna.length; j++) {
                vertical += dna[j].charAt(i);
            }
            contador += Arrays.stream(busqueda).anyMatch(vertical::contains) ? 1 : 0;

            diagIni = i < 3 ? diagIni -1 : 0;
            diagFin = i < 4 ? (diagComienzo * 2) + 1 : diagFin -1;
            diagIndiceIni = i < 3 ? 0 : diagIndiceIni + 1;
            diagIndice = diagIndiceIni;
            for (int k = diagIni; k < diagFin; k++) {
                diag[k] += dna[i].charAt(diagIndice);
                diagInv[k] += dna[i].charAt(5-diagIndice);
                diagIndice++;
            }
            if (contador >=2) return true;
        }
        for (int i = 0; i < diagCant; i++) {
            contador += Arrays.stream(busqueda).anyMatch(diag[i]::contains) ? 1 : 0;
            contador += Arrays.stream(busqueda).anyMatch(diagInv[i]::contains) ? 1 : 0;
        }
        return contador >= 2;
    }
}