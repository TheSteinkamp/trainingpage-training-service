package com.example.training_service.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionExerciseDTO {
    private Long id;
    private int sets;
    private int repetitions;
    @Column(length = 1000)
    private String description;
    private String exerciseId;
    private String name;
}
