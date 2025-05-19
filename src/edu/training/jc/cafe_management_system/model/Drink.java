package edu.training.jc.cafe_management_system.model;

public enum Drink {
    ESPRESSO(0, 15, 15),
    LATTE(20, 0, 5),
    CAPPUCCINO(5, 0, 10);

    private final int milk;
    private final int water;
    private final int coffee;

    Drink(int milk, int water, int coffee) {
        this.milk = milk;
        this.water = water;
        this.coffee = coffee;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public int getCoffee() {
        return coffee;
    }
}
