package com.vpratha.exercisetracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExerciseDTO(
        String name,
        Integer sets,
        Integer reps,
        Double weight,
        Integer duration)
{}

