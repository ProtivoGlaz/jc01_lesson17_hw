package edu.training.jc.cafe_management_system.ui;

import java.util.Scanner;

import edu.training.jc.cafe_management_system.controller.CafeController;
import edu.training.jc.cafe_management_system.model.CoffeeMachine;

public class CafeUI {
	Scanner scanner = new Scanner(System.in);
	private final CafeController cafeController;
	private CoffeeMachine currentCoffeeMachine;

	public CafeUI(CafeController cafeController) {
		this.cafeController = cafeController;
	}

	public void displayMenu() {
		while (true) {
			System.out.println("\n==== Cafe Management Menu ====");
			System.out.println("1. Add coffee machine");
			System.out.println("2. Remove coffee machine");
			System.out.println("3. Refill coffee machine");
			System.out.println("4. Make beverage");
			System.out.println("9. Show all coffee machines");
			System.out.println("0. Exit");
			System.out.print("Choose option: ");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1 -> addCoffeeMachine();
			case 2 -> removeCoffeeMachine();
			case 3 -> refill();
			case 4 -> makeBeverage();
			case 9 -> showAllCoffeeMachines();
			case 0 -> {
				System.out.println("Exiting.");
				return;
			}
			default -> System.out.println("Invalid option.");
			}
		}
	}

	// 1
	public void addCoffeeMachine() {
		currentCoffeeMachine = new CoffeeMachine();
		cafeController.addCoffeeMachine(currentCoffeeMachine);
		System.out.println("Coffee machine added.");
	}

	// 2
	public void removeCoffeeMachine() {
		System.out.println("Enter the ID of the coffee machine: ");
		int id = Integer.parseInt(scanner.nextLine());
		CoffeeMachine tempCoffeeMachine = cafeController.findByID(id);
		if (tempCoffeeMachine != null) {
			cafeController.removeCoffeeMachibe(tempCoffeeMachine);
		} else {
			System.out.println("-1");
		}
	}

	// 3
	public void refill() {
		System.out.println("Enter the ID of the coffee machine: ");
		int id = Integer.parseInt(scanner.nextLine());
		CoffeeMachine tempCoffeeMachine = cafeController.findByID(id);
		cafeController.refill(tempCoffeeMachine);
	}

	// 4
	public void makeBeverage() {
		while (true) {
			System.out.println("\n==== Menu ====");
			System.out.println("1. Latte");
			System.out.println("2. Espresso");
			System.out.println("3. Cappuccino");
			System.out.println("4. Return");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {

			case 1 -> {
				System.out.print("\nEnter ID coffee machine: ");
				choice = Integer.parseInt(scanner.nextLine());
				cafeController.makeLatte(choice);
			}
			case 2 -> {
				System.out.print("\nEnter ID coffee machine: ");
				choice = Integer.parseInt(scanner.nextLine());
				cafeController.makeEspresso(choice);
			}
			case 3 -> {
				System.out.print("\nEnter ID coffee machine: ");
				choice = Integer.parseInt(scanner.nextLine());
				cafeController.makeCappuccino(choice);
			}
			case 4 -> {
				System.out.println("Return.");
				return;
			}
			}
		}
	}

	// 9
	public void showAllCoffeeMachines() {
		cafeController.getInformation();
	}
}
