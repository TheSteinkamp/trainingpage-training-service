package com.example.training_service.DTO;

public record SessionExerciseRequest(int sets,
                                     int repetitions,
                                     String description,
                                     String exerciseId,
                                     String name) {
}
