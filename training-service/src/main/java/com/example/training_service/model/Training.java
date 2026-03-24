package com.example.training_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String description;
    private LocalDate date;
    private int duration;
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Exercise> exercises;
}
