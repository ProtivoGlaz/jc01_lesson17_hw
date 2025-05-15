package edu.training.jc.cafe_management_system.repository;

import java.util.ArrayList;
import java.util.List;

import edu.training.jc.cafe_management_system.model.CoffeeMachine;
import edu.training.jc.cafe_management_system.model.Drink;

public class CafeRepository {
	private List<CoffeeMachine> coffeeMachines = new ArrayList<>();
	// case -> 1
	public void addCoffeeMachine(CoffeeMachine coffeeMachine) {
		coffeeMachines.add(coffeeMachine);
		System.out.println("addCoffeeMachine [CafeRepository]");
	}
	// case -> 2
	public void removeCoffeeMachibe(CoffeeMachine coffeeMachine) {
		coffeeMachines.remove(coffeeMachine);
		System.out.println("removeCoffeeMachine OBJECT [CafeRepository]");
	}
	// case -> 3
	public void refillCoffeeMachine(CoffeeMachine c) {
		
		for (CoffeeMachine coffeeMachine : coffeeMachines) {
			if (coffeeMachine.equals(c)) {
				coffeeMachine.setCoffee(100);
				coffeeMachine.setWater(100);
				coffeeMachine.setMilk(100);
			}
		}
		System.out.println("refill [CafeRepository]");
	}
	// case -> 4
	public Drink makeLatte(int id) {
		for (CoffeeMachine coffeeMachine : coffeeMachines) {
			if (coffeeMachine.getId() == id) {
				 return coffeeMachine.makeLatte();
			} 
		}
		return null;
	}
	public Drink makeEspresso(int id) {
		for (CoffeeMachine coffeeMachine : coffeeMachines) {
			if (coffeeMachine.getId() == id) {
				 return coffeeMachine.makeEspresso();
			} 
		}
		return null;
	}
	public Drink makeCappuccino(int id) {
		for (CoffeeMachine coffeeMachine : coffeeMachines) {
			if (coffeeMachine.getId() == id) {
				 return coffeeMachine.makeCappuccino();
			} 
		}
		return null;
	}
	// case -> 9
	public void getInformation() {
		System.out.println("=====");
		for (CoffeeMachine coffeMachine : coffeeMachines) {
			System.out.println(coffeMachine);
		}
		System.out.println("=====");
	}
	// поиск кофемашины по ID
	public CoffeeMachine findByID(int id) {
		System.out.println("findByID [CafeRepository]");
		for (CoffeeMachine coffeeMachine : coffeeMachines) {
			if (coffeeMachine.getId() == id) {
				System.out.println("Coffee machine with this ID found");
				return coffeeMachine;
			} else {
				System.out.println("Coffee machine with this ID was not found");
			}
		}
		return null;
	}
	
	public boolean alarm() {
		for (CoffeeMachine coffeeMachine : coffeeMachines) {
			if (coffeeMachine.getCoffee() == 0 || coffeeMachine.getMilk() == 0 || coffeeMachine.getWater() == 0) {
				System.out.println("ALARM" + coffeeMachine);
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
}
