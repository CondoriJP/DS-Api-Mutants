package com.frm.utn.dsapimutants.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class DNA {
    @Id
    @GeneratedValue
    private Long id;
    private Boolean isMutant;
    @Column(unique = true)
    private String[] dna;
}