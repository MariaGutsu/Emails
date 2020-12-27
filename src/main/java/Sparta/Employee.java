package Sparta;

public class Employee {
	String lastName;
	String firstName;
	String level;
	int rate;

	public Employee(String lastName, String firstName, String level) {
		this.lastName = lastName;
		this.firstName = firstName;
		switch (level) {
			case "Middle":
				this.rate = 15;
				break;
			case "Senior":
				this.rate = 20;
			default:
				this.rate = 10;
		}
	}
}
