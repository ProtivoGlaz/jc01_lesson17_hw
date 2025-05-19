package edu.training.jc.cafe_management_system.model;

import java.util.Objects;

public class CoffeeMachine {
    public static final int MAX_LEVEL_MILK = 100;
    public static final int MAX_LEVEL_WATER = 100;
    public static final int MAX_LEVEL_COFFEE = 100;

    private int milk;
    private int water;
    private int coffee;

    public CoffeeMachine() {
        this.milk = 0;
        this.water = 0;
        this.coffee = 0;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public boolean canMakeDrink(Drink drink) {
        return this.milk >= drink.getMilk() &&
               this.water >= drink.getWater() &&
               this.coffee >= drink.getCoffee();
    }

    public void prepareDrink(Drink drink) {
        if (!canMakeDrink(drink)) {
            throw new IllegalStateException("Not enough resources for " + drink.name());
        }
        this.milk -= drink.getMilk();
        this.water -= drink.getWater();
        this.coffee -= drink.getCoffee();
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffee, milk, water);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CoffeeMachine other = (CoffeeMachine) obj;
        return coffee == other.coffee && milk == other.milk && water == other.water;
    }

    @Override
    public String toString() {
        return "CoffeeMachine [milk=" + milk + ", water=" + water + ", coffee=" + coffee + "]";
    }
}
