package com.sparta.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {


	public String getLevel() {
		return level;
	}

	public String getPosition() {
		return position;
	}

	@JsonProperty("lastname")
	String lastName;
	@JsonProperty("firstname")
	String firstName;
	String level;
	String position;
	int rate;

}

