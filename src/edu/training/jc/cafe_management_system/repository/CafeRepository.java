package edu.training.jc.cafe_management_system.repository;

import java.util.ArrayList;
import java.util.List;
import edu.training.jc.cafe_management_system.model.CoffeeMachine;

public class CafeRepository {
	private List<CoffeeMachine> coffeeMachines = new ArrayList<>();

	public void saveCoffeeMachines(List<CoffeeMachine> machines) {
		this.coffeeMachines = new ArrayList<>(machines);
	}

	public List<CoffeeMachine> getAllCoffeeMachines() {
		return coffeeMachines;
	}
}
