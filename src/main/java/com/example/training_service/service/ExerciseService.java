package com.example.training_service.service;

import com.example.training_service.enums.BodyParts;
import com.example.training_service.enums.Difficulty;
import com.example.training_service.model.Exercise;
import com.example.training_service.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise addExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> getExercisesByBodyPart(@PathVariable String bodypart) {
        return exerciseRepository.getExercisesByBodyPart(bodypart.toLowerCase());
    }

    public List<Exercise> getExercisesByBodyPartAndDifficulty(String bodyPart, String difficulty) {
        return exerciseRepository.getExercisesByBodyPartAndDifficulty(bodyPart.toLowerCase(), difficulty.toLowerCase());
    }

    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    public List<String> findBodyPartList() {
        return Arrays.stream(BodyParts.values()).map(bp -> bp.label).toList();
    }

    public List<String> findDifficultyList() {
        return Arrays.stream(Difficulty.values()).map(bp -> bp.label).toList();
    }


}
