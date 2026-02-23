package com.vpratha.exercisetracker.database.entity;

import com.vpratha.exercisetracker.dto.ExerciseNameDTO;
import com.vpratha.exercisetracker.enums.ExerciseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ExerciseName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false, updatable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private ExerciseType type;

    public ExerciseName(ExerciseNameDTO exerciseNameDTO) {
        this.name = exerciseNameDTO.name();
        this.type = ExerciseType.valueOf(exerciseNameDTO.type());
    }
}
