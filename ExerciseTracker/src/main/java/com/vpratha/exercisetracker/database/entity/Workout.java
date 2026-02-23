package com.vpratha.exercisetracker.database.entity;

import com.vpratha.exercisetracker.database.entity.exercise.Exercise;
import com.vpratha.exercisetracker.enums.WorkoutType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Workout {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private WorkoutType type;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Exercise> exercises = new ArrayList<>();

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        exercise.setWorkout(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date: ").append(date).append("\n");
        sb.append("Type: ").append(type).append("\n");
        sb.append("--------------------------\n");
        for (Exercise e : exercises) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}
