package com.example.demo.repositories;

import com.example.demo.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,Long> {
}
