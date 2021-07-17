package com.jindekara.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FoodChain {
    PREDATOR("Хищный"),
    HERBIVORE("Травоядный"),
    OMNIVORE("Всеядный");

    private final String foodChain;

    FoodChain(String foodChain) {
        this.foodChain = foodChain;
    }

    @JsonValue
    public String getFoodChainStatus() {
        return foodChain;
    }
}
