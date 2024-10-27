package com.frm.utn.dsapimutants.repositories;

import com.frm.utn.dsapimutants.entities.DNA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends JpaRepository<DNA, Long> {
    @Query("SELECT COUNT(d) FROM DNA d WHERE d.isMutant = :isMutant")
    int countMutants(boolean isMutant);

   @Query("SELECT d FROM DNA d WHERE d.dna = :dna")
    DNA findByDNA(String dna);
}