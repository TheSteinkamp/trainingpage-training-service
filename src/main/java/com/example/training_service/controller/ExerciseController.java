package com.example.training_service.controller;

import com.example.training_service.DTO.ExerciseDTO;
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

    @GetMapping("/bodypartlist")
    public List<String> findBodyPartList() {
        return exerciseService.findBodyPartList();
    }

    @GetMapping("/difficultylist")
    public List<String> findDifficultyList() {
        return exerciseService.findDifficultyList();
    }

    @GetMapping("/bodypart/{bodypart}/difficulty/{difficulty}")
    public List<ExerciseDTO> getExercisesByBodyPartAndDifficulty(@PathVariable String bodypart, @PathVariable String difficulty) {
        return exerciseService.getExercisesByBodyPartAndDifficulty(bodypart, difficulty);
    }

    @PostMapping("/session")
    public List<ExerciseDTO> getExercisesPerSession(@RequestBody Map<String, List<String>> request) {
        List<String> ids = request.get("ids");
        return exerciseService.getExercisesPerSession(ids);
    }
}

