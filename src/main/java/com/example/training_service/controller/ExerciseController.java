package com.example.training_service.controller;

import com.example.training_service.model.Exercise;
import com.example.training_service.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public List<Exercise> getAllExercises() {
        return exerciseService.getAll();
    }

    @GetMapping("/bodypartlist")
    public List<String> findBodyPartList() {
        return exerciseService.findBodyPartList();
    }
    @GetMapping("/difficultylist")
    public List<String> findDifficultyList() {
        return exerciseService.findDifficultyList();
    }

    @GetMapping("/bodypart/{bodypart}")
    public List<Exercise> getExercisesByBodyPart(@PathVariable String bodypart) {
        return exerciseService.getExercisesByBodyPart(bodypart);
    }

    @GetMapping("/bodypart/{bodypart}/difficulty/{difficulty}")
    public List<Exercise> getExercisesByBodyPartAndDifficulty(@PathVariable String bodypart, @PathVariable String difficulty) {
        return exerciseService.getExercisesByBodyPartAndDifficulty(bodypart, difficulty);
    }

}

