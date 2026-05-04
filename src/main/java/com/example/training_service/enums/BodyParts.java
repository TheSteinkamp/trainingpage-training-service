package com.example.training_service.enums;

public enum BodyParts {
    BACK("Back"),
    CARDIO("Cardio"),
    CHEST("Chest"),
    LOWERARMS("Lower arms"),
    LOWERLEGS("Lower legs"),
    NECK("Neck"),
    SHOULDERS("Shoulders"),
    UPPERARMS("Upper arms"),
    UPPERLEGS("Upper legs"),
    WAIST("Waist");

    public final String label;

    BodyParts(String label) {
        this.label = label;
    }
}
