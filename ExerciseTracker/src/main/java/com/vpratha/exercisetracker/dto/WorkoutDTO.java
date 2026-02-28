package com.vpratha.exercisetracker.dto;

import java.util.List;

public record WorkoutDTO(
        Long id,
        String date,
        String type,
        List<ExerciseDTO> exercises)
{}
