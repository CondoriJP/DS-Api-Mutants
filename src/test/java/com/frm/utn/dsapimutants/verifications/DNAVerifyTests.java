package com.frm.utn.dsapimutants.verifications;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DNAVerifyTests {

    @Test   // Test con matriz no cuadrada
    public void testVerifyDNA1() {
        String[] dna = new String[] {"ATGCGA","CAGGC","TTAT","AGAAGG","CCCCTA","TCACTGGGGG"};
        Exception exception = Assertions.assertThrows(Exception.class, () -> DNAVerify.verifyDNA(dna));
        Assertions.assertEquals("[!] La matriz no es cuadrada", exception.getMessage());
    }

    @Test   // Test con caracteres inválidos
    public void testVerifyDNA2() {
        String[] dna = new String[]{"ATZZGA", "CAGTGC", "TTATGT", "JUANGG", "CCCCTA", "TCACTG"};
        Exception exception = Assertions.assertThrows(Exception.class, () -> DNAVerify.verifyDNA(dna));
        Assertions.assertEquals("[!] La matriz contiene caracteres inválidos", exception.getMessage());
    }

    @Test   // Test con matriz nula
    public void testVerifyDNA3() {
        String[] dna = null;
        Exception exception = Assertions.assertThrows(Exception.class, () -> DNAVerify.verifyDNA(dna));
        Assertions.assertEquals("[!] JSON key no encontrada", exception.getMessage());
    }
}