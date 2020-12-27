package Sparta;

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

		String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\MariaGutsu\\IdeaProjects\\SpartaTraining\\src\\main\\resources\\test.json")));
		List<Employee> employees = new ObjectMapper()
				.readValue(content, new TypeReference<List<Employee>>() {});

		Project sparta = new Project("Sparta");

		Developers developers = new Developers();
		developers.addEmployee(new Employee(employees.get(0).getLastName(), employees.get(0).getFirstName(), employees.get(0).getLevel()));
		developers.addEmployee(new Employee(employees.get(1).getLastName(), employees.get(1).getFirstName(), employees.get(1).getLevel()));
		developers.addEmployee(new Employee(employees.get(2).getLastName(), employees.get(2).getFirstName(), employees.get(2).getLevel()));

		Managers managers = new Managers();
		managers.addEmployee(new Employee(employees.get(3).getLastName(), employees.get(3).getFirstName(), employees.get(3).getLevel()));
		managers.addEmployee(new Employee( employees.get(4).getLastName(), employees.get(4).getFirstName(), employees.get(4).getLevel()));

		BA ba = new BA();
		ba.addEmployee(new Employee(employees.get(5).getLastName(), employees.get(5).getFirstName(), employees.get(5).getLevel()));
		ba.addEmployee(new Employee( employees.get(6).getLastName(), employees.get(6).getFirstName(), employees.get(6).getLevel()));

		QA qa = new QA();
		qa.addEmployee(new Employee(employees.get(7).getLastName(), employees.get(7).getFirstName(), employees.get(7).getLevel()));
		qa.addEmployee(new Employee( employees.get(8).getLastName(), employees.get(8).getFirstName(), employees.get(8).getLevel()));
		qa.addEmployee(new Employee( employees.get(9).getLastName(), employees.get(9).getFirstName(), employees.get(9).getLevel()));

		sparta.addPosition(developers);
		sparta.addPosition(managers);
		sparta.addPosition(ba);
		sparta.addPosition(qa);


		System.out.println(sparta.calculateBillingOrder());

	}

}

