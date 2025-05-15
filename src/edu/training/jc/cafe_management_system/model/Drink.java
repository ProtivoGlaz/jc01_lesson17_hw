package edu.training.jc.cafe_management_system.model;

import java.util.Objects;

public class Drink {
	private String name;
	
	public String getName() {
		return name;
	}

	public Drink(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Drink [name=" + name + "]\n";
	}
	
	
	
}
