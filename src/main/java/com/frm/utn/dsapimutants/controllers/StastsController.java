package com.frm.utn.dsapimutants.controllers;

import com.frm.utn.dsapimutants.dto.StatsDto;
import com.frm.utn.dsapimutants.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stats")
public class StastsController {
    private final StatsService statsService;

    @Autowired
    public StastsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public ResponseEntity<StatsDto> getStats() {
        return new ResponseEntity<StatsDto>(statsService.calcStats(), HttpStatus.OK);
    }
}
