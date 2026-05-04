package com.example.training_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {
    private Long id;
    private String type;
    private String description;
    private LocalDate date;
    private int duration;
    private Long userId;
    private List<SessionExerciseDTO> exercises;
}
