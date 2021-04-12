package com.jindekara.enums;

public enum Sex {
    MAN("мужской"),
    NEUTRAL("нейтральный"),
    WOMAN("женский");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
