package com.example.training_service.DTO;

import com.example.training_service.model.SessionExercise;

import java.time.LocalDate;
import java.util.List;

public record TrainingRequest(Long id,
        String type,
        String description,
        LocalDate date,
        int duration,
        Long userId,
List<SessionExercise> exercises) {
}
