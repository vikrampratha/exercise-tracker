package com.vpratha.exercisetracker.database.repo;

import com.vpratha.exercisetracker.database.entity.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
}
