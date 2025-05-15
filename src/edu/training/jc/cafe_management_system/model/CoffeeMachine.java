package edu.training.jc.cafe_management_system.model;

import java.util.Objects;

public class CoffeeMachine {
	private static int ID = 0;
	private int id;

	private int milk = 0;
	private int water = 0;
	private int coffee = 0;

	{
		ID++;
	}

	public CoffeeMachine() {
		this.id = ID;
	}

	public int getId() {
		return id;
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
	
	public Drink makeLatte() {
		this.coffee -= 10;
		this.milk -= 10;
		this.water -= 10;
		System.out.println("makeLatte [CoffeeMachine]");
		return new Drink("Latte");
	}
	
	public Drink makeEspresso() {
		this.coffee -= 15;
		this.milk -= 15;
		this.water -= 15;
		System.out.println("makeEspresso [CoffeeMachine]");
		return new Drink("Espresso");
	}
	
	public Drink makeCappuccino() {
		this.coffee -= 5;
		this.milk -= 5;
		this.water -= 5;
		System.out.println("makeCappuccino [CoffeeMachine]");
		return new Drink("Cappuccino");
	}

	@Override
	public int hashCode() {
		return Objects.hash(coffee, id, milk, water);
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
		return coffee == other.coffee && id == other.id && milk == other.milk && water == other.water;
	}

	@Override
	public String toString() {
		return "CoffeeMachine [id=" + id + ", milk=" + milk + ", water=" + water + ", coffee=" + coffee + "]\n";
	}

}
