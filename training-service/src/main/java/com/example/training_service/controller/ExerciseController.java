package com.example.training_service.controller;

import com.example.training_service.model.Exercise;
import com.example.training_service.service.ExerciseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/add")
    public Exercise addExercise(@RequestBody Exercise exercise) {
    return exerciseService.addExercise(exercise);
    }
}

