package com.jindekara.enums;

public enum SectionBestiary {
    DEFAULT("Обчные"),
    DEMONS("Демоны"),
    REASONABLE("Разумные"),
    SUB_RACES("Подрассы");

    private final String section;

    SectionBestiary(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }
}

