package com.example.training_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
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
}
