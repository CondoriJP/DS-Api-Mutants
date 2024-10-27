package com.frm.utn.dsapimutants.repositories;

import com.frm.utn.dsapimutants.entities.DNA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends JpaRepository<DNA, Long> {
    int countMutants(boolean isMutant);
}