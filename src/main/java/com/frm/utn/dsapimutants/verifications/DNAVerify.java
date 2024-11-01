package com.frm.utn.dsapimutants.verifications;

public class DNAVerify {
    public static void verifyDNA(String[] dna) throws Exception {
        // 1) Verifica que la key del JSON sea correcta
        if (dna == null) throw new Exception("[!] JSON key no encontrada");

        // 2) Verifica que la matriz sea cuadrada y que solo contenga los caracteres A, T, C y G
        for (String s : dna) {
            if (s.length() != dna.length) throw new Exception("[!] La matriz no es cuadrada");
            if (!s.matches("[ATCG]+")) throw new Exception("[!] La matriz contiene caracteres inválidos");
            if (dna.length < 4) throw new Exception("[!] La matriz es muy pequeña");
        }
    }
}