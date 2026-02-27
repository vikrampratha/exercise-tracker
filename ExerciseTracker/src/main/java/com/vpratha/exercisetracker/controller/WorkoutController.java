package com.vpratha.exercisetracker.controller;

import com.vpratha.exercisetracker.database.entity.Workout;
import com.vpratha.exercisetracker.database.repo.WorkoutRepo;
import com.vpratha.exercisetracker.dto.WorkoutDTO;
import com.vpratha.exercisetracker.enums.WorkoutType;
import com.vpratha.exercisetracker.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

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
    public List<WorkoutDTO> getAllWorkouts() {
        List<WorkoutDTO> workouts = workoutRepo.findAll()
                .stream()
                .map(workoutService::mapToDTO)
                .toList();
        System.out.println(workouts);
        return workouts;
    }

    @GetMapping("/workouts/recent")
    public List<WorkoutDTO> getRecentWorkouts() {
        return workoutRepo.findTop10ByOrderByDateDesc()
                .stream()
                .map(workoutService::mapToDTO) // your DTO mapper
                .toList();
    }

    @GetMapping("/workouts/recent")
    public List<WorkoutDTO> getRecentWorkoutsByType(@RequestParam WorkoutType type) {
        return workoutRepo.findTop10ByTypeOrderByDateDesc(type)
                .stream()
                .map(workoutService::mapToDTO)
                .toList();
    }
}
