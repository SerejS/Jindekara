package com.jindekara.enums;

public enum Sex {
    MAN("мужской"),
    WOMAN("женский");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return sex;
    }
}
