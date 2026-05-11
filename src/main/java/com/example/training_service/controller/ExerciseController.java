package com.example.training_service.controller;

import com.example.training_service.DTO.ExerciseDTO;
import com.example.training_service.DTO.SessionExerciseRequest;
import com.example.training_service.model.SessionExercise;
import com.example.training_service.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/add")
    public SessionExercise addExercise(@RequestBody SessionExerciseRequest exercise) {
    return exerciseService.addExercise(exercise);
    }

    @GetMapping("/all")
    public List<ExerciseDTO> getAllExercises() {
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
    public List<ExerciseDTO> getExercisesByBodyPart(@PathVariable String bodypart) {
        return exerciseService.getExercisesByBodyPart(bodypart);
    }

    @GetMapping("/bodypart/{bodypart}/difficulty/{difficulty}")
    public List<ExerciseDTO> getExercisesByBodyPartAndDifficulty(@PathVariable String bodypart, @PathVariable String difficulty) {
        return exerciseService.getExercisesByBodyPartAndDifficulty(bodypart, difficulty);
    }

    @PostMapping("/session")
    public List<ExerciseDTO> getExercisesPerSession(@RequestBody Map<String, List<String>> request) {
        System.out.println("in getExercisesPerSession controller");
        List<String> ids = request.get("ids");
        return exerciseService.getExercisesPerSession(ids);
    }
}

