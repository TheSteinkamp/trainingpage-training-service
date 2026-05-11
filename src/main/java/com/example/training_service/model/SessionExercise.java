package com.example.training_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionExercise {
    @Id
    @GeneratedValue
    private Long id;
    private int sets;
    private int repetitions;
    @Column(length = 1000)
    private String description;
    private String exerciseId;
    private String name;
}
