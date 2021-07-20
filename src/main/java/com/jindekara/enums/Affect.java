package com.jindekara.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Affect {
    DEFAULT("Логос"),
    FARKS("Фаркс"),
    ALDUIN("Алдуин"),
    SERANA("Серана"),
    ARCHITECTOR("Архитектор"),
    DEMONS("Демоны"),
    SPIRITS("Духи"),
    HEROES("Герои");

    private final String name;

    Affect(String s) {
        this.name = s;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}