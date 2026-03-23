package com.example.training_service.controller;

import com.example.training_service.entity.Training;
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
    public List<Training> getAllTrainings() {
    return trainingService.findAll();
}

@PostMapping("/new")
    public Training createTraining(@RequestBody Training training) {
    return trainingService.addTraining(training);
}

@GetMapping("/{id}")
    public Training getTrainingById(@PathVariable Long id) {
    return trainingService.findById(id);
}

}
