package com.example.demo.repositories;

import com.example.demo.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepo extends JpaRepository<Seance,Long> {
}
