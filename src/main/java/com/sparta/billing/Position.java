package com.sparta.billing;

import java.util.ArrayList;
import java.util.List;

public class Position {
	List<Employee> employees;

	public Position() {
		employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		switch (employee.getLevel()) {
			case "Middle":
				employee.rate += 15;
				break;
			case "Senior":
				employee.rate += 20;
				break;
			default:
				employee.rate += 10;
		}
		employees.add(employee);
	}

	public int calculateBillingOrder() {
		int result = 0;
		for (Employee e : employees) {
			result += e.rate;
		}
		return result;
	}
}
