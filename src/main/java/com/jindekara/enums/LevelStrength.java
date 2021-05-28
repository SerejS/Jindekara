package com.jindekara.enums;

public enum LevelStrength {
    WEAKEST("Очень слабое"),
    WEAK("Слабое"),
    NORMAL("Среднее"),
    STRONG("Сильное"),
    STRONGEST("Очень сильное");

    private String strength;

    LevelStrength(String strength) {
        this.strength = strength;
    }

    public String getStrength() {
        return strength;
    }
}
