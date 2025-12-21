package com.vpratha.exercisetracker.database.entity.exercise;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CARDIO")
@Getter
@Setter
public class CardioExercise extends Exercise {
    private Integer duration;

    @Override
    public String toString() {
        return super.toString() + ": " + duration + " min";
    }
}
