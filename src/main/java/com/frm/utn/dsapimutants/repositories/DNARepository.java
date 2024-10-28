package com.frm.utn.dsapimutants.repositories;

import com.frm.utn.dsapimutants.entities.DNA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DNARepository extends JpaRepository<DNA, Long> {
    @Query("SELECT COUNT(d) FROM DNA d WHERE d.isMutant = :isMutant")
    int countMutants(boolean isMutant);

    @Query("SELECT d.isMutant FROM DNA d WHERE d.dna = :dna")
    Optional<Boolean> findByDNA(String[] dna);
}