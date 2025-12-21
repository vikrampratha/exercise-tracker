package com.vpratha.exercisetracker.database.repo;

import com.vpratha.exercisetracker.database.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepo extends JpaRepository<Workout, Long> {
}
