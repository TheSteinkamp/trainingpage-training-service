package com.example.training_service.repository;

import com.example.training_service.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> getExercisesByBodyPart(@PathVariable String bodypart);

    @Query("SELECT e FROM Exercise e " +
            "WHERE e.bodyPart = :bodyPart " +
            "AND e.difficulty = :difficulty")
    List<Exercise> getExercisesByBodyPartAndDifficulty(@Param("bodyPart") String bodyPart, @Param("difficulty") String difficulty);


}
