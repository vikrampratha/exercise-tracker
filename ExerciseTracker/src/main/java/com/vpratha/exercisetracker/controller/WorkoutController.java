package com.vpratha.exercisetracker.controller;

import com.vpratha.exercisetracker.database.entity.Workout;
import com.vpratha.exercisetracker.database.repo.WorkoutRepo;
import com.vpratha.exercisetracker.dto.WorkoutDTO;
import com.vpratha.exercisetracker.service.WorkoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkoutController {
    private final WorkoutService workoutService;
    private final WorkoutRepo workoutRepo;

    public WorkoutController(WorkoutService workoutService, WorkoutRepo workoutRepo) {
        this.workoutService = workoutService;
        this.workoutRepo = workoutRepo;
    }

    @PostMapping("/createWorkout")
    public String createWorkout(@RequestBody WorkoutDTO workoutDTO) {
        Workout workout = workoutService.insertWorkout(workoutDTO);
        return workout.toString();
    }

    @GetMapping("/getAllWorkouts")
    public String getAllWorkouts() {
        List<Workout> workouts = workoutRepo.findAll();
        return workouts.toString();
    }
}
