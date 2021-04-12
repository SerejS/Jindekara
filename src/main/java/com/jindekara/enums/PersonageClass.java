package com.jindekara.enums;

public enum PersonageClass {
    COMMON("Обыватель"),
    WARRIOR("Воин"),
    MAGICIAN("Маг"),
    BARD("Музыкант"),
    CRIMINAL("Преступик"),
    MIXED("Смешанный");

    String character_class;

    PersonageClass(String character_class) {
        this.character_class = character_class;
    }
}
