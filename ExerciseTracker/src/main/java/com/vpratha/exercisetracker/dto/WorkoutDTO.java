package com.vpratha.exercisetracker.dto;

import java.util.List;

public record WorkoutDTO(
        String date,
        String type,
        List<ExerciseDTO> exercises)
{}
