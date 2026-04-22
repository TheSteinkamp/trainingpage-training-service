package com.example.training_service.enums;

public enum BodyParts {
    BACK("back"),
    CARDIO("cardio"),
    CHEST("chest"),
    LOWERARMS("lower arms"),
    LOWERLEGS("lower legs"),
    NECK("neck"),
    SHOULDERS("shoulders"),
    UPPERARMS("upper arms"),
    UPPERLEGS("upper legs"),
    WAIST("waist");

    public final String label;

    private BodyParts(String label) {
        this.label = label;
    }
}
