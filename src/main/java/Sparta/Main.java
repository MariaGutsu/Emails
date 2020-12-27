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
		System.out.println(employees.get(0).getLastName());
		System.out.println(employees.get(0).getFirstName());

		Project sparta = new Project("Sparta");

		Developers developers = new Developers();
		developers.addEmployee(new Employee("Levchuk", "Andrey", "Senior"));
		developers.addEmployee(new Employee( "Dvoretsky", "Denis", "Middle"));
		developers.addEmployee(new Employee( "Murashko", "Dmitry", "Middle"));

		Managers managers = new Managers();
		managers.addEmployee(new Employee("Rubanov", "Alexander", "Senior"));
		managers.addEmployee(new Employee( "Semukha", "Sergey", "Middle"));

		BA ba = new BA();
		ba.addEmployee(new Employee("Molochko", "Alexandra", "Senior"));
		ba.addEmployee(new Employee( "Stephanovich", "Daria", "Junior"));

		QA qa = new QA();
		qa.addEmployee(new Employee("Pobortseva", "Anna", "Senior"));
		qa.addEmployee(new Employee( "Zelenkova", "Lena", "Middle"));
		qa.addEmployee(new Employee( "Prokopovich", "Julia", "Junior"));

		sparta.addPosition(developers);
		sparta.addPosition(managers);
		sparta.addPosition(ba);
		sparta.addPosition(qa);


		System.out.println(sparta.calculateBillingOrder());

	}

}

