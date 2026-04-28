package com.example.training_service.service;
import com.example.training_service.DTO.TrainingDTO;
import com.example.training_service.DTO.TrainingRequest;
import com.example.training_service.model.Training;
import com.example.training_service.repository.TrainingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<TrainingDTO> findAll() {
        List<Training> trainingList = trainingRepository.findAll();
        return trainingToDTO(trainingList);
    }

    public List<TrainingDTO> findByUser(Long id) {
        List<Training> trainingList= trainingRepository.findByUserId(id);
        return trainingToDTO(trainingList);
    }

    public TrainingDTO addTraining(TrainingRequest training) {
        Training newTraining = modelMapper.map(training, Training.class);
        trainingRepository.save(newTraining);
        return modelMapper.map(newTraining, TrainingDTO.class);
    }

    public List<TrainingDTO> trainingToDTO(List<Training> trainingList) {
        List<TrainingDTO> trainingDTOList = new ArrayList<>();
        for (Training training : trainingList) {
            TrainingDTO trainingDTO = modelMapper.map(training, TrainingDTO.class);
            trainingDTOList.add(trainingDTO);
        }
        return trainingDTOList;
    }
}
