package com.frm.utn.dsapimutants.services;

import com.frm.utn.dsapimutants.dto.StatsDto;
import com.frm.utn.dsapimutants.repositories.DNARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    private final DNARepository dnaRepository;

    @Autowired
    public StatsService(DNARepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public StatsDto calcStats() {
        long mutants = dnaRepository.countMutants(true);
        long humans = dnaRepository.countMutants(false);
        return new StatsDto(mutants, humans, humans == 0 ? 1 : (double) mutants / humans);
    }
}