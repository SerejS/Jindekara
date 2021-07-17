package com.jindekara.enums;

import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public String getStrength() {
        return strength;
    }
}
