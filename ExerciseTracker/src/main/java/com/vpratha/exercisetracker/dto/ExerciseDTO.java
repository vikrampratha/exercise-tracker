package com.vpratha.exercisetracker.dto;

public record ExerciseDTO(
        String name,
        Integer sets,
        Integer reps,
        Double weight,
        Integer duration)
{}

