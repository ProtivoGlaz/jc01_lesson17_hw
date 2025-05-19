package edu.training.jc.cafe_management_system.service;

import java.util.List;

import edu.training.jc.cafe_management_system.model.CoffeeMachine;
import edu.training.jc.cafe_management_system.model.Drink;
import edu.training.jc.cafe_management_system.repository.CafeRepository;

public class CafeService {
	private final CafeRepository cafeRepository;

	private static final int MAX_MILK = CoffeeMachine.MAX_LEVEL_MILK;
	private static final int MAX_WATER = CoffeeMachine.MAX_LEVEL_WATER;
	private static final int MAX_COFFEE = CoffeeMachine.MAX_LEVEL_COFFEE;

	public CafeService(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}

	public void addCoffeeMachine(CoffeeMachine machine) {
		List<CoffeeMachine> machines = cafeRepository.getAllCoffeeMachines();
		machines.add(machine);
		cafeRepository.saveCoffeeMachines(machines);
	}

	public void removeCoffeeMachine(CoffeeMachine machine) {
		List<CoffeeMachine> machines = cafeRepository.getAllCoffeeMachines();
		if (!machines.remove(machine)) {
			throw new IllegalArgumentException("Coffee machine not found: " + machine);
		}
		cafeRepository.saveCoffeeMachines(machines);
	}

	public void refill(CoffeeMachine machine) {
		CoffeeMachine target = findCoffeeMachine(machine);
		target.setMilk(MAX_MILK);
		target.setWater(MAX_WATER);
		target.setCoffee(MAX_COFFEE);
		cafeRepository.saveCoffeeMachines(cafeRepository.getAllCoffeeMachines());
	}

	public void makeDrink(CoffeeMachine machine, Drink drink) {
		CoffeeMachine target = findCoffeeMachine(machine);
		target.prepareDrink(drink);
		cafeRepository.saveCoffeeMachines(cafeRepository.getAllCoffeeMachines());
	}

	public List<CoffeeMachine> getInformation() {
		return cafeRepository.getAllCoffeeMachines();
	}

	public CoffeeMachine findCoffeeMachine(CoffeeMachine machine) {
		List<CoffeeMachine> machines = cafeRepository.getAllCoffeeMachines();
		for (CoffeeMachine m : machines) {
			if (m.equals(machine)) {
				return m;
			}
		}
		throw new IllegalArgumentException("Coffee machine not found: " + machine);
	}
}
