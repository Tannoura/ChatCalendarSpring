package com.example.demo.services;

import com.example.demo.entities.Schedule;
import com.example.demo.repositories.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl {

    @Autowired
    private ScheduleRepo scheduleRepository;


    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isPresent()) {
            Schedule existingSchedule = optionalSchedule.get();
            // Mettez à jour les champs de l'horaire existant selon les détails de l'horaire fourni
            // Assurez-vous de gérer les relations avec les séances si nécessaire
            // existingSchedule.setXXX(scheduleDetails.getXXX());
            return scheduleRepository.save(existingSchedule);
        } else {
            // Gérer l'erreur si l'horaire n'est pas trouvé
            return null;
        }
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

}
