package com.sparta.billing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
@Data
public class Main {

	public static void main(String[] args) throws IOException {

		String content = new String(Files.readAllBytes(Paths.get("src\\main\\resources\\test.json")));
		List<Employee> employees = new ObjectMapper()
				.readValue(content, new TypeReference<List<Employee>>() {});

		Project sparta = new Project("com/sparta/billing");

		Developers developers = new Developers();
		Position managers = new Managers();
		Position bas = new BA();
		QA qas = new QA();

		for (Employee e: employees) {
			switch (e.getPosition()) {
				case "developer":
					developers.addEmployee(e);
					break;
				case "manager":
					managers.addEmployee(e);
					break;
				case "ba":
					bas.addEmployee(e);
					break;
				case "qa":
					qas.addEmployee(e);
					break;
			}
		}

		sparta.addPosition(developers);
		sparta.addPosition(managers);
		sparta.addPosition(bas);
		sparta.addPosition(qas);


		System.out.println(sparta.calculateBillingOrder());

	}

}

