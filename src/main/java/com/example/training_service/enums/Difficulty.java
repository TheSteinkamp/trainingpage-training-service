package com.example.training_service.enums;

public enum Difficulty {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    public final String label;

    Difficulty(String label) {
        this.label = label;
    }
}
