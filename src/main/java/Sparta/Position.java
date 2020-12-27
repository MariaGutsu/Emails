package Sparta;

import java.util.ArrayList;
import java.util.List;

public class Position {
	List<Employee> employees;

	public Position() {
		employees = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
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
