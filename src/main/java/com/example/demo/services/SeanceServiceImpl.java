package com.example.demo.services;


import com.example.demo.entities.Seance;
import com.example.demo.repositories.SeanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceServiceImpl {
    @Autowired
    private SeanceRepo seanceRepo;


    public List<Seance> getAllSeances() {
        return seanceRepo.findAll();
    }

    public Seance createSeance(Seance seance) {
        return seanceRepo.save(seance);
    }

    public Seance getSeanceById(Long id) {
        return seanceRepo.findById(id).orElse(null);
    }
    public Seance updateSeance(Long id, Seance seanceDetails) {
        Optional<Seance> optionalSeance = seanceRepo.findById(id);
        if (optionalSeance.isPresent()) {
            Seance existingSeance = optionalSeance.get();
            existingSeance.setStartDateTime(seanceDetails.getStartDateTime());
            existingSeance.setEndDateTime(seanceDetails.getEndDateTime());
            existingSeance.setDescription(seanceDetails.getDescription());
            return seanceRepo.save(existingSeance);
        } else {
            // Gérer l'erreur si la séance n'est pas trouvée
            return null;
        }
    }

    public void deleteSeance(Long id) {
        seanceRepo.deleteById(id);
    }
}
