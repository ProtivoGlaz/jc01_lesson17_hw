package edu.training.jc.cafe_management_system.service;

import edu.training.jc.cafe_management_system.model.CoffeeMachine;
import edu.training.jc.cafe_management_system.model.Drink;
import edu.training.jc.cafe_management_system.repository.CafeRepository;

public class CafeService {
	private final CafeRepository cafeRepository;
	
	public CafeService(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}
	// case -> 1
	public void addCoffeeMachine(CoffeeMachine coffeeMachine) {
		cafeRepository.addCoffeeMachine(coffeeMachine);
		System.out.println("addCoffeeMachine [CafeService]");
	}
	// case -> 2
	public void removeCoffeeMachibe(CoffeeMachine coffeeMachine) {
		cafeRepository.removeCoffeeMachibe(coffeeMachine);;
		System.out.println("removeCoffeeMachine [CafeService]");
	}
	// case -> 3
	public void refill(CoffeeMachine coffeeMachine) {
		cafeRepository.refillCoffeeMachine(coffeeMachine);
		System.out.println("refill [CafeService]");
	}
	// case -> 4
	public Drink makeLatte(int id) {
		return cafeRepository.makeLatte(id);
	}
	public Drink makeEspresso(int id) {
		return cafeRepository.makeEspresso(id);
	}
	public Drink makeCappuccino(int id) {
		return cafeRepository.makeCappuccino(id);
	}
	// проверка по ID
		public boolean isEmpty(int id) {
			CoffeeMachine tempCoffeeMachine = cafeRepository.findByID(id);
			if (tempCoffeeMachine != null) {
				return true;
			} else {
				return false;
			}
		}
	// case -> 9
	public void getInformation() {
		cafeRepository.getInformation();
		System.out.println("getInformation [CafeService]");
	}
	
	// поиск кофемашины по ID
	public CoffeeMachine findByID(int id) {
		System.out.println("findByID [CafeService]");
		return cafeRepository.findByID(id);
	}
	
	public boolean alarm() {
		return cafeRepository.alarm();
	}
}
