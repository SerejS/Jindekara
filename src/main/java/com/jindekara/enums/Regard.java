package com.jindekara.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Regard {
    FRIENDLY("Дружелюбный"),
    NEUTRAL("Нейтральный"),
    HOSTILE("Враждебный");

    private final String regard;

    Regard(String regard) {
        this.regard = regard;
    }

    @JsonValue
    public String getRegard() {
        return regard;
    }
}
