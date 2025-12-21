package com.vpratha.exercisetracker.controller;

import com.vpratha.exercisetracker.database.entity.ExerciseName;
import com.vpratha.exercisetracker.database.repo.ExerciseNameRepo;
import com.vpratha.exercisetracker.dto.ExerciseNameDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExerciseNameController {
    private final ExerciseNameRepo exerciseNameRepo;

    public ExerciseNameController(ExerciseNameRepo exerciseNameRepo) {
        this.exerciseNameRepo = exerciseNameRepo;
    }

    @PostMapping("/createExerciseName")
    public ExerciseName createExerciseName(@RequestBody ExerciseNameDTO exerciseNameDTO) {
        ExerciseName exerciseName = new ExerciseName(exerciseNameDTO);
        log.info("{}, {}", exerciseName.getName(), exerciseName.getType());
        return exerciseNameRepo.save(new ExerciseName(exerciseNameDTO));
    }
}
