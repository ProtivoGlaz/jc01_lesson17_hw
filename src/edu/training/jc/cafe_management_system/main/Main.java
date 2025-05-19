package edu.training.jc.cafe_management_system.main;

import edu.training.jc.cafe_management_system.repository.CafeRepository;
import edu.training.jc.cafe_management_system.service.CafeService;
import edu.training.jc.cafe_management_system.ui.CafeUI;

public class Main {

	public static void main(String[] args) {

		CafeUI ui = new CafeUI(new CafeService(new CafeRepository()));

		ui.displayMenu();

	}

}
