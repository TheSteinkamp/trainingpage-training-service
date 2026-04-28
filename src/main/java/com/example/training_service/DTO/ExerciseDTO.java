package com.example.training_service.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;

import java.util.List;

public class ExerciseDTO {
    private String id;
    private String name;
    private String bodyPart;
    private String equipment;
    private String target;
    @ElementCollection
    private List<String> secondaryMuscles;
    @Column(length = 2000)
    @ElementCollection
    private List<String> instructions;
    @Column(length = 1000)
    private String description;
    private String difficulty;
    private String category;

    public ExerciseDTO(String id, String name, String bodyPart, String equipment, String target, List<String> secondaryMuscles, List<String> instructions, String description, String difficulty, String category) {
    }
}

