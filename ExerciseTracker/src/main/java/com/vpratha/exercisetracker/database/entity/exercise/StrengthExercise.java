package com.vpratha.exercisetracker.database.entity.exercise;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("STRENGTH")
@Getter
@Setter
public class StrengthExercise extends Exercise {
    private Integer sets;
    private Integer reps;

    @Override
    public String toString() {
        return super.toString() + ": " + sets + "x" + reps;
    }
}
