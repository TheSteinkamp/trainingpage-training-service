package com.example.training_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private LocalDate date;
    private LocalTime length;
    private Long userId;
    @ManyToMany
    private List<Exercise> exercises;
}
