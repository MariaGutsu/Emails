package Sparta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Employee {

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLevel() {
		return level;
	}
@JsonProperty("lastname")
	String lastName;
	@JsonProperty("firstname")
	String firstName;
	String level;
	int rate;

	public Employee() {
	}

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
