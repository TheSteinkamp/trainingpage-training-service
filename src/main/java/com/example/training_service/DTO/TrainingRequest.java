package com.example.training_service.DTO;

import java.time.LocalDate;
import java.util.List;

public record TrainingRequest(String type,
        String description,
        LocalDate date,
        int duration,
        Long userId,
        List<SessionExerciseRequest> sessionExercises) {
}
