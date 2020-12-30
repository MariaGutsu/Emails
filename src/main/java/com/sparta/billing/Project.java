package com.sparta.billing;

import java.util.ArrayList;
import java.util.List;

public class Project {

	String name;
	List<Position> positions;


	public Project(String name) {
		this.name = name;
		positions = new ArrayList<>();
	}

	public int calculateBillingOrder() {
		int result = 0;
		for (Position s : positions) {
			result += s.calculateBillingOrder();
		}
		return result;
	}

	public void addPosition(Position position) {
		positions.add(position);
	}
}
