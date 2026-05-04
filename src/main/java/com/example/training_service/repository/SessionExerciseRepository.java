package com.example.training_service.repository;

import com.example.training_service.model.SessionExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionExerciseRepository extends JpaRepository<SessionExercise, Long> {
}
