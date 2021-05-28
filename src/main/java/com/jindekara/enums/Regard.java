package com.jindekara.enums;

public enum Regard {
    FRIENDLY("Дружелюбный"),
    NEUTRAL("Нейтральный"),
    HOSTILE("Враждебный");

    private final String regard;

    Regard(String regard) {
        this.regard = regard;
    }

    public String getRegard() {
        return regard;
    }
}
