package com.frm.utn.dsapimutants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsApiMutantsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DsApiMutantsApplication.class, args);
        System.out.println("[+] API Mutants is running...");
    }
}
