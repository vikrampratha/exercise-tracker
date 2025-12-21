package com.vpratha.exercisetracker.database.entity.exercise;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("WEIGHTED_STRENGTH")
@Getter
@Setter
public class WeightedStrengthExercise extends StrengthExercise {
    private Double weight;

    @Override
    public String toString() {
        return super.toString() + " " + weight + " lbs";
    }
}
