package com.example.training_service.DTO;

import jakarta.persistence.Column;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {
    private String id;
    private String name;
    private String bodyPart;
    private String equipment;
    private String target;
    private List<String> secondaryMuscles;
    @Column(length = 2000)
    private List<String> instructions;
    @Column(length = 1000)
    private String description;
    private String difficulty;
    private String category;
}

