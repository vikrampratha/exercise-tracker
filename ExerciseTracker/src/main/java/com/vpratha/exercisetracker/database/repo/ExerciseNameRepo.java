package com.vpratha.exercisetracker.database.repo;

import com.vpratha.exercisetracker.database.entity.ExerciseName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseNameRepo extends JpaRepository<ExerciseName, Long> {
    ExerciseName findByName(String name);
}
