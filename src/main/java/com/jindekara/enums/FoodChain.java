package com.jindekara.enums;

public enum FoodChain {
    PREDATOR("Хищный"),
    HERBIVORE("Травоядный"),
    OMNIVORE("Всеядный");

    private final String foodChain;
    FoodChain(String foodChain) {
        this.foodChain = foodChain;
    }

    public String getFoodChainStatus() {
        return foodChain;
    }
}
