package com.vpratha.exercisetracker.database.repo;

import com.vpratha.exercisetracker.database.entity.Workout;
import com.vpratha.exercisetracker.enums.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepo extends JpaRepository<Workout, Long> {
    List<Workout> findTop10ByOrderByDateDesc();
    List<Workout> findTop10ByTypeOrderByDateDesc(WorkoutType type);
}
