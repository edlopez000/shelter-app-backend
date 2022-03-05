package com.shelterapp.backend.util.enums;

public enum RatingEnum {

    NO("No Issues"),
    MILD("Mild Issues"),
    MODERATE("Moderate Issues"),
    SIGNIFICANT("Significant Issues");

    private final String displayName;

    RatingEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    private RatingEnum type;

}
