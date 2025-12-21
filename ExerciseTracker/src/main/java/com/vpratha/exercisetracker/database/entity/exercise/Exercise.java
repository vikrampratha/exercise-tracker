package com.vpratha.exercisetracker.database.entity.exercise;

import com.vpratha.exercisetracker.database.entity.ExerciseName;
import com.vpratha.exercisetracker.database.entity.Workout;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "exercise_type")
@Getter
@Setter
public abstract class Exercise {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    private ExerciseName exerciseName;

    @Override
    public String toString() {
        return exerciseName.getName();
    }
}
