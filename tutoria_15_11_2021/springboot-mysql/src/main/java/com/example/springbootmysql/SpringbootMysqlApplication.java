package com.example.springbootmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringbootMysqlApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootMysqlApplication.class, args);
		EmployeeRepository repository = context.getBean(EmployeeRepository.class);

		Employee emp = new Employee(null, "Emp1", true, 40000d, LocalDate.now());
		repository.save(emp);
	}

}
