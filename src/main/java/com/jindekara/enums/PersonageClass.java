package com.jindekara.enums;

public enum PersonageClass {
    COMMON("Обыватель"),
    WARRIOR("Воин"),
    MAGICIAN("Маг"),
    BARD("Музыкант"),
    CRIMINAL("Преступик"),
    MIXED("Смешанный");

    String personage_class;

    PersonageClass(String personage_class) {
        this.personage_class = personage_class;
    }

    @Override
    public String toString() {
        return personage_class;
    }
}
