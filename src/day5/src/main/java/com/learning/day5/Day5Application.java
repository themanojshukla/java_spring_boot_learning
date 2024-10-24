package day5.src.main.java.com.learning.day5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day5Application implements CommandLineRunner {

	// Dependency
	@Autowired
	private Calculator calculator;


	public static void main(String[] args) {
		SpringApplication.run(Day5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");

		var sum = calculator.add(1, 2);
		var diff = calculator.subtract(10, 5);

		System.out.println("Sum: " + sum);
		System.out.println("Diff: " + diff);
	}
}
