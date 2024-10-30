package com.frm.utn.dsapimutants.services;

import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DNAServiceTests {
    /*
     * Tests de Cobertura
     */
    static String[] busqueda = {"AAAA", "CCCC", "GGGG", "TTTT"};
    static ArrayList<String> dnaLineaTrue;
    static ArrayList<String> dnaLineaFalse;
    static ArrayList<String[]> dnaTrue;
    static ArrayList<String[]> dnaFalse;

    @AfterAll
    public static void limpiar() {
        dnaFalse = null;
        dnaTrue = null;
        dnaLineaFalse = null;
        dnaLineaTrue = null;
    }

    @BeforeAll
    public static void dnaIniciales() {
        dnaFalse = new ArrayList<String[]>();
        dnaTrue = new ArrayList<String[]>();
        dnaLineaFalse = new ArrayList<String>();
        dnaLineaTrue = new ArrayList<String>();

        dnaFalse.add(new String[] {"ATGC", "CAGT", "TTAT", "AGCF"});
        dnaFalse.add(new String[] {"GGGAG", "TACGA", "TATAC", "AGGCA", "GTTTC"});
        dnaFalse.add(new String[] {"TTTATTCCTCGT", "TTTGAGCGACTT", "ACCATGACTTGC", "GTAAGGTAAGGT", "CTACGTGGGTAA", "TAGCCCATGATC", "GGCGCTAACACT", "TTATGATATACG", "CCATCTGTATAC", "CTCATATGCCAT", "CTTGCGCATCCG", "ATAAGAGTTTCG"});

        dnaTrue.add(new String[] {"CAGCTACGGGAT", "CGGTTTCCATAC", "AGTACAGATCCC", "CTTCACGCTCGC", "GTAAGACGAGGC", "GCGAATCGCATC", "CAAGCATCTTCA", "TAATGGACCGGC", "ATTGTCTGCCCT", "CGGGATACTAGA", "GGCTCTAGGTCA", "AGACTCGGCCGC"});
        dnaTrue.add(new String[] {"CCCGGCTT", "GTTCGTGG", "GTAGGCAG", "TCCTGAGT", "CAACGTGC", "CATCTATA", "TTAAAAGT", "CTGTTCGA"});
        dnaTrue.add(new String[] {"ACTA", "CAAT", "TAAT", "AGCA"});

        // Matriz para testear las columnas
        dnaTrue.add(new String[] {"GCTA", "CACA", "TCCA", "AGCA"});
        dnaTrue.add(new String[] {"GGGCG", "TGGAA", "TGGAC", "AGGCA", "GGGTC"});

        dnaLineaFalse.add("ATGC");
        dnaLineaFalse.add("CAGTGCAHAHAHAHAHAH");
        dnaLineaFalse.add("TTATGTHAHAHAHAHHAHA");
        dnaLineaFalse.add("AGAAGGAHAHAH");
        dnaLineaFalse.add("CCTCTAAAGAGG");
        dnaLineaFalse.add("TCACTGAAHAHAHHAHAHAHHAHAHHAHAHHAHAH");
        dnaLineaTrue.add("TTTT");
        dnaLineaTrue.add("CAAAAC");
        dnaLineaTrue.add("TTAFFFFAAAA");
        dnaLineaTrue.add("AGAAAAAAFFFFFFFF");
        dnaLineaTrue.add("CCGCGCGCGCGCGCGCGCGCGCGGGGGG");
        dnaLineaTrue.add("TCACCCCTG");
    }

    @Test
    public void testIsMutantTrue1() {
        assertTrue(DNAService.isMutant(dnaTrue.get(0)));
    }

    @Test
    public void testIsMutantTrue2() {
        assertTrue(DNAService.isMutant(dnaTrue.get(1)));
    }

    @Test
    public void testIsMutantTrue3() {
        assertTrue(DNAService.isMutant(dnaTrue.get(2)));
    }

    @Test
    public void testIsMutantFalse() {
        for (String[] dna : dnaFalse) {
            assertFalse(DNAService.isMutant(dna));
        }
    }

    @Test
    public void testFilasTrue() {
        for (String dna : dnaLineaTrue) {
            assertEquals(1,Arrays.stream(busqueda).anyMatch(dna::contains) ? 1 : 0);
        }
    }

    @Test
    public void testFilasFalse() {
        for (String dna : dnaLineaFalse) {
            assertEquals(0,Arrays.stream(busqueda).anyMatch(dna::contains) ? 1 : 0);
        }
    }

    public static boolean isMutant(String[] dna) {
        int n = dna.length;
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

    @Test
    public void testColumnasTrue1() {
        String[] dna = dnaTrue.get(3);
        StringBuilder vertical;
        int contador = 0;
        for (int i = 0; i < dna.length; i++) {
            vertical = new StringBuilder();
            for (String s : dna) vertical.append(s.charAt(i));
            contador += Arrays.stream(busqueda).anyMatch(vertical.toString()::contains) ? 1 : 0;
        }
        assertEquals(1, contador);
    }

    @Test
    public void testColumnasTrue2() {
        String[] dna = dnaTrue.get(4);
        StringBuilder vertical;
        int contador = 0;
        for (int i = 0; i < dna.length; i++) {
            vertical = new StringBuilder();
            for (String s : dna) vertical.append(s.charAt(i));
            contador += Arrays.stream(busqueda).anyMatch(vertical.toString()::contains) ? 1 : 0;
        }
        assertEquals(2, contador);
    }
}