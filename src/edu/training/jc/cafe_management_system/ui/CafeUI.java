package edu.training.jc.cafe_management_system.ui;

import java.util.List;
import java.util.Scanner;

import edu.training.jc.cafe_management_system.model.CoffeeMachine;
import edu.training.jc.cafe_management_system.model.Drink;
import edu.training.jc.cafe_management_system.service.CafeService;

public class CafeUI {
	private final Scanner scanner = new Scanner(System.in);
	private final CafeService cafeService;

	public CafeUI(CafeService cafeService) {
		this.cafeService = cafeService;
	}

	public void displayMenu() {
		while (true) {
			System.out.println("\n==== Cafe Management Menu ====");
			System.out.println("1. Add coffee machine");
			System.out.println("2. Remove coffee machine");
			System.out.println("3. Refill coffee machine");
			System.out.println("4. Make drink");
			System.out.println("5. Show all coffee machines");
			System.out.println("0. Exit");
			System.out.print("Choose option: ");

			try {
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1 -> addCoffeeMachine();
				case 2 -> removeCoffeeMachine();
				case 3 -> refillCoffeeMachine();
				case 4 -> makeDrink();
				case 5 -> showAllCoffeeMachines();
				case 0 -> {
					System.out.println("Exiting.");
					return;
				}
				default -> System.out.println("Invalid option.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid number.");
			}
		}
	}

	private void addCoffeeMachine() {
		CoffeeMachine machine = new CoffeeMachine();
		cafeService.addCoffeeMachine(machine);
		System.out.println("Coffee machine added.");
	}

	private void removeCoffeeMachine() {
		List<CoffeeMachine> machines = cafeService.getInformation();
		if (machines.isEmpty()) {
			System.out.println("There are no coffee machines to remove.");
			return;
		}
		showAllCoffeeMachines();
		System.out.print("Select the coffee machine to be deleted (number): ");
		try {
			int choice = Integer.parseInt(scanner.nextLine());
			if (choice < 1 || choice > machines.size()) {
				System.out.println("Invalid coffee machine number.");
				return;
			}
			cafeService.removeCoffeeMachine(machines.get(choice - 1));
			System.out.println("Coffee machine removed.");
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid number.");
		}
	}

	private void refillCoffeeMachine() {
		List<CoffeeMachine> machines = cafeService.getInformation();
		if (machines.isEmpty()) {
			System.out.println("No refill coffee machines.");
			return;
		}
		showAllCoffeeMachines();
		System.out.print("Select the coffee machine to be refilled (number): ");
		try {
			int choice = Integer.parseInt(scanner.nextLine());
			if (choice < 1 || choice > machines.size()) {
				System.out.println("Invalid coffee machine number.");
				return;
			}
			cafeService.refill(machines.get(choice - 1));
			System.out.println("Coffee machine refilled.");
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid number.");
		}
	}

	private void makeDrink() {
		List<CoffeeMachine> machines = cafeService.getInformation();
		if (machines.isEmpty()) {
			System.out.println("No available coffee machines.");
			return;
		}

		showAllCoffeeMachines();
		System.out.print("Select the coffee machine (number): ");
		try {
			int machineChoice = Integer.parseInt(scanner.nextLine());
			if (machineChoice < 1 || machineChoice > machines.size()) {
				System.out.println("Invalid coffee machine number.");
				return;
			}
			CoffeeMachine machine = machines.get(machineChoice - 1);

			Drink[] drinks = Drink.values();
			for (int i = 0; i < drinks.length; i++) {
				System.out.println((i + 1) + ". " + drinks[i].name());
			}
			System.out.print("Choose a drink: ");

			int drinkChoice = Integer.parseInt(scanner.nextLine());
			if (drinkChoice < 1 || drinkChoice > drinks.length) {
				System.out.println("Invalid drink selection.");
				return;
			}
			Drink drink = drinks[drinkChoice - 1];

			try {
				cafeService.makeDrink(machine, drink);
				System.out.println("Drink " + drink.name() + " is made.");
			} catch (IllegalStateException | IllegalArgumentException e) {
				System.out.println("Exception: " + e.getMessage());
			}
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid number.");
		}
	}

	private void showAllCoffeeMachines() {
		List<CoffeeMachine> machines = cafeService.getInformation();
		System.out.println("==== List of coffee machines ====");
		if (machines.isEmpty()) {
			System.out.println("There are no coffee machines.");
		} else {
			for (int i = 0; i < machines.size(); i++) {
				System.out.println((i + 1) + ". " + machines.get(i));
			}
		}
		System.out.println("==========================");
	}
}
