package com.example.demo.controllers;

import com.example.demo.entities.Seance;
import com.example.demo.services.SeanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
@CrossOrigin(origins = "*")

public class SeanceController {

    @Autowired
    private SeanceServiceImpl seanceService;

    @GetMapping
    public List<Seance> getAllSeances() {
        return seanceService.getAllSeances();
    }

    @GetMapping("/{id}")
    public Seance getSeanceById(@PathVariable Long id) {
        return seanceService.getSeanceById(id);
    }

    @PostMapping
    public Seance createSeance(@RequestBody Seance seance) {
        return seanceService.createSeance(seance);
    }

    @PutMapping("/{id}")
    public Seance updateSeance(@PathVariable Long id, @RequestBody Seance seance) {
        return seanceService.updateSeance(id, seance);
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
    }

}
