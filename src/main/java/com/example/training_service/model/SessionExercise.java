package com.example.training_service.model;

import jakarta.persistence.Entity;
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
    private Long id;
    private int sets;
    private int repetitions;
    private String comments;
    private String exerciseId;
}
