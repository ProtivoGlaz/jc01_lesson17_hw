package edu.training.jc.cafe_management_system.controller;

import edu.training.jc.cafe_management_system.model.CoffeeMachine;
import edu.training.jc.cafe_management_system.model.Drink;
import edu.training.jc.cafe_management_system.service.CafeService;

public class CafeController {
	private final CafeService cafeService;
	
	public CafeController(CafeService cafeService) {
		this.cafeService = cafeService;
	}
	
	// case -> 1
	public void addCoffeeMachine(CoffeeMachine coffeeMachine) {
		cafeService.addCoffeeMachine(coffeeMachine);
		System.out.println("addCoffeeMachine [CafeController]");
	}
	// case -> 2
	public void removeCoffeeMachibe(CoffeeMachine coffeeMachine) {
		cafeService.removeCoffeeMachibe(coffeeMachine);
		System.out.println("removeCoffeeMachine OBJECT [CafeController]");
	}
	// case -> 3
	public void refill(CoffeeMachine coffeeMachine) {
		cafeService.refill(coffeeMachine);
		System.out.println("refill [CafeController]");
	}
	// case -> 4
	public Drink makeLatte(int id) {
		System.out.println(cafeService.isEmpty(id));
		if (cafeService.alarm()) {
			Drink latte = cafeService.makeLatte(id);
			return latte;
		} else {
			System.out.println("-1");
			return null;
		}
		
	}
	public Drink makeEspresso(int id) {
		System.out.println(cafeService.isEmpty(id));
		if (cafeService.alarm()) {
			Drink espresso = cafeService.makeEspresso(id);
			return espresso;
		} else {
			System.out.println("-1");
			return null;
		}
	}
	public Drink makeCappuccino(int id) {
		System.out.println(cafeService.isEmpty(id));
		if (cafeService.alarm()) {
			Drink cappuccino = cafeService.makeCappuccino(id);
			return cappuccino;
		} else {
			System.out.println("-1");
			return null;
		}
	}
	// case -> 9
	public void getInformation() {
		cafeService.getInformation();
		System.out.println("getInformation [CafeController]");
	}
	
	// поиск кофемашины по ID
	public CoffeeMachine findByID(int id) {
		System.out.println("findByID [CafeService]");
		return cafeService.findByID(id);
	}
}
