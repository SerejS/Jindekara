package com.jindekara.enums;

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

    public String getName() {
        return name;
    }
}