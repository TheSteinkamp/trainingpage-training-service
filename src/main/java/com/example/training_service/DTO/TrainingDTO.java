package com.example.training_service.DTO;

import com.example.training_service.model.SessionExercise;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

public class TrainingDTO {
    private Long id;
    private String type;
    private String description;
    private LocalDate date;
    private int duration;
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SessionExercise> exercises;
}
