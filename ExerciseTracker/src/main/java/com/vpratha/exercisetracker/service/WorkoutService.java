package com.vpratha.exercisetracker.service;

import com.vpratha.exercisetracker.database.entity.ExerciseName;
import com.vpratha.exercisetracker.database.entity.Workout;
import com.vpratha.exercisetracker.database.entity.exercise.CardioExercise;
import com.vpratha.exercisetracker.database.entity.exercise.Exercise;
import com.vpratha.exercisetracker.database.entity.exercise.StrengthExercise;
import com.vpratha.exercisetracker.database.entity.exercise.WeightedStrengthExercise;
import com.vpratha.exercisetracker.database.repo.ExerciseNameRepo;
import com.vpratha.exercisetracker.database.repo.WorkoutRepo;
import com.vpratha.exercisetracker.dto.ExerciseDTO;
import com.vpratha.exercisetracker.dto.WorkoutDTO;
import com.vpratha.exercisetracker.enums.ExerciseType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WorkoutService {

    private final WorkoutRepo workoutRepo;
    private final ExerciseNameRepo exerciseNameRepo;

    public WorkoutService(WorkoutRepo workoutRepo, ExerciseNameRepo exerciseNameRepo) {
        this.workoutRepo = workoutRepo;
        this.exerciseNameRepo = exerciseNameRepo;
    }

    @Transactional
    public Workout insertWorkout(WorkoutDTO workoutDTO) {
        Workout workout = new Workout();

        workout.setDate(LocalDate.parse(workoutDTO.date()));

        for (ExerciseDTO exerciseDTO : workoutDTO.exercises()) {
            Exercise exercise = createExercise(exerciseDTO);
            workout.addExercise(exercise);
        }
        return workoutRepo.save(workout);
    }

    /**
     * Helper method called by insertWorkout().
     * Converts an exercise
     * @param exerciseDTO exerciseDTO.name() must exist in the ExerciseName JPA Repository.
     * @return an Exercise object based on ExerciseDTO's type
     */
    private Exercise createExercise(ExerciseDTO exerciseDTO) {
        ExerciseName name = exerciseNameRepo.findByName(exerciseDTO.name());
        ExerciseType type = name.getType();

        switch (type) {
            case CARDIO -> {
                CardioExercise c = new CardioExercise();
                c.setExerciseName(name);
                c.setDuration(exerciseDTO.duration());
                return c;
            }
            case STRENGTH -> {
                StrengthExercise s = new StrengthExercise();
                s.setExerciseName(name);
                s.setSets(exerciseDTO.sets());
                s.setReps(exerciseDTO.reps());
                return s;
            }
            case WEIGHTED_STRENGTH -> {
                WeightedStrengthExercise w = new WeightedStrengthExercise();
                w.setExerciseName(name);
                w.setSets(exerciseDTO.sets());
                w.setReps(exerciseDTO.reps());
                w.setWeight(exerciseDTO.weight());
                return w;
            }
            default -> throw new IllegalStateException("Unsupported type: " + type);
        }
    }
}
