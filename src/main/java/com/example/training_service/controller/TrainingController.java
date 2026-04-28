package com.example.training_service.controller;

import com.example.training_service.DTO.TrainingDTO;
import com.example.training_service.DTO.TrainingRequest;
import com.example.training_service.model.Training;
import com.example.training_service.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

private TrainingService trainingService;

public TrainingController(TrainingService trainingService) {
    this.trainingService = trainingService;
}

@GetMapping("/all")
    public List<TrainingDTO> getAllTrainings() {
    return trainingService.findAll();
}

@PostMapping("/new")
    public TrainingDTO createTraining(@RequestBody TrainingRequest training) {
    return trainingService.addTraining(training);
}

@GetMapping("/user/{id}")
    public List<TrainingDTO> getTrainingsByUserId(@PathVariable Long id) {
    return trainingService.findByUser(id);
}

}
