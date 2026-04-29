package com.example.training_service.service;
import com.example.training_service.DTO.SessionExerciseRequest;
import com.example.training_service.DTO.TrainingDTO;
import com.example.training_service.DTO.TrainingRequest;
import com.example.training_service.model.SessionExercise;
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

    public void addTraining(TrainingRequest training) {
        Training newTraining = trainingRequestToTraining(training);
        trainingRepository.save(newTraining);
    }

    public Training trainingRequestToTraining(TrainingRequest request) {
        Training training = new Training();
        training.setType(request.type());
        training.setDescription(request.description());
        training.setDate(request.date());
        training.setDuration(request.duration());
        training.setUserId(request.userId());
        List<SessionExercise> sessionList = new ArrayList<>();

        for (SessionExerciseRequest session: request.sessionExercises()){
            SessionExercise sessionExercise = new SessionExercise();
            sessionExercise.setDescription(session.description());
            sessionExercise.setName(session.name());
            sessionExercise.setSets(session.sets());
            sessionExercise.setRepetitions(session.repetitions());
            sessionExercise.setExerciseId(session.exerciseId());
            sessionList.add(sessionExercise);
        }
        training.setExercises(sessionList);
        //Training savedTraining = trainingRepository.save(training);
        return training;
                //modelMapper.map(savedTraining, TrainingDTO.class);
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
