package com.example.training_service.service;

import com.example.training_service.model.Training;
import com.example.training_service.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;

    public List<Training> findAll() {
        return trainingRepository.findAll();
    }
    public List<Training> findByUser(Long id) {
        return trainingRepository.findByUserId(id);
    }
    public Training addTraining(Training training) {
        return trainingRepository.save(training);
    }
}
