package com.jindekara.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sex {
    MAN("Мужчина"),
    WOMAN("Женщина");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    @JsonValue
    @Override
    public String toString() {
        return sex;
    }
}
