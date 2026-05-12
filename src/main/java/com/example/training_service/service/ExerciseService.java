package com.example.training_service.service;

import com.example.training_service.DTO.ExerciseDTO;
import com.example.training_service.enums.BodyParts;
import com.example.training_service.enums.Difficulty;
import com.example.training_service.model.Exercise;
import com.example.training_service.repository.ExerciseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<ExerciseDTO> getExercisesByBodyPartAndDifficulty(String bodyPart, String difficulty) {
        List <Exercise> exerciseList = exerciseRepository.getExercisesByBodyPartAndDifficulty(bodyPart.toLowerCase(), difficulty.toLowerCase());
        return exerciseToDTO(exerciseList);
    }

    public List<String> findBodyPartList() {
        return Arrays.stream(BodyParts.values()).map(bp -> bp.label).toList();
    }

    public List<String> findDifficultyList() {
        return Arrays.stream(Difficulty.values()).map(bp -> bp.label).toList();
    }

    public List<ExerciseDTO> getExercisesPerSession(List<String> id) {
        List<Exercise> exerciseList = exerciseRepository.findAllByIdIn(id);
        System.out.println(exerciseList.size());
        return exerciseToDTO(exerciseList);
    }

    public List<ExerciseDTO> exerciseToDTO(List<Exercise> exerciseList) {
        List<ExerciseDTO> exerciseDTOList = new ArrayList<>();
        for (Exercise exercise : exerciseList) {
            ExerciseDTO exerciseDTO = modelMapper.map(exercise, ExerciseDTO.class);
            exerciseDTOList.add(exerciseDTO);
        }
        return exerciseDTOList;
    }

}
