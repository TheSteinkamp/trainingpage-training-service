package com.example.training_service.DTO;

public record SessionExerciseRequest(Long id,
                                     int sets,
                                     int repetitions,
                                     String comments,
                                     String exerciseId) {
}
