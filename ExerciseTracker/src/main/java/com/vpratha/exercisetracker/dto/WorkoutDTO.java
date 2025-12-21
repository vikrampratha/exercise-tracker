package com.vpratha.exercisetracker.dto;

import java.util.List;

public record WorkoutDTO(
        String date,
        List<ExerciseDTO> exercises)
{}
