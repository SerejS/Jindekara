package com.jindekara.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SectionBestiary {
    DEFAULT("Обычные"),
    DEMONS("Демоны"),
    REASONABLE("Разумные"),
    SUB_RACES("Подрасы");

    private final String section;

    SectionBestiary(String section) {
        this.section = section;
    }

    @JsonValue
    public String getSection() {
        return section;
    }
}

