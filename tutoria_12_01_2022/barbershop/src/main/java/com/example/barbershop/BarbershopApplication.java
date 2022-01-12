package com.example.barbershop;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.entities.Customer;
import com.example.barbershop.entities.Employee;
import com.example.barbershop.entities.HairAssistance;
import com.example.barbershop.repository.AppointmentRepository;
import com.example.barbershop.repository.CustomerRepository;
import com.example.barbershop.repository.EmployeeRepository;
import com.example.barbershop.repository.HairAssistanceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BarbershopApplication {

	public static void main(String[] args) {




		ApplicationContext context = SpringApplication.run(BarbershopApplication.class, args);

		// CITA
		AppointmentRepository appRepository = context.getBean(AppointmentRepository.class);

		Appointment cita1 = new Appointment(
				null,
				LocalDateTime.of(2022, 1, 14, 10, 30),
				60,
				"Lorem ipsum dolor sit amet");


		appRepository.save(cita1);

		// CLIENTE
		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

		Customer customer = new Customer(null, "Customer1", "lastname1", "customer1@example.com",
				LocalDate.of(1990, 1, 3));

		// customer.getAppointments().add(cita1);

		customerRepository.save(customer);

		// ASOCIACIÓN APPOINTMENT - CUSTOMER
		cita1.setCustomer(customer);
		appRepository.save(cita1);

		// COMPROBAR QUE AL BUSCAR EL APPOINTMENT RECUPERA TAMBIÉN EL CUSTOMER
		Optional<Appointment> appointmentOpt = appRepository.findById(1L);
		Appointment appointment1 = null;
		if(appointmentOpt.isPresent()) {
			appointment1 = appointmentOpt.get();
			System.out.println(appointment1.getCustomer());
		}


		// ESCENARIO INVERSO (IMPORTANTE: Como Customer no es owner de la asociación entonces no se guarda en base de datos esa asociación )
		Appointment cita2 = new Appointment(null, LocalDateTime.now(), 60, "Lorem ipsum dolor sit amet");
		appRepository.save(cita2);
		Appointment cita3 = new Appointment(null, LocalDateTime.now(), 60, "Lorem ipsum dolor sit amet");
		appRepository.save(cita3);

		Customer customer2 = new Customer(null, "customer2", "lastname2", "customer2@example.com", null);
		customer2.getAppointments().add(cita2);
		customer2.getAppointments().add(cita3);
		customerRepository.save(customer2);


		// HAIR ASSISTANCE

		HairAssistanceRepository hairAssistRepository = context.getBean(HairAssistanceRepository.class);
		HairAssistance cortePeloM = new HairAssistance(null, "Corte Pelo hombre", 12d, 40);
		HairAssistance cortePeloF = new HairAssistance(null, "Corte Pelo femenino", 20d, 80);
		hairAssistRepository.save(cortePeloM);
		hairAssistRepository.save(cortePeloF);


		// HAIR ASSISTANCE - APPOINTMENT
		cita1.setHairAssistance(cortePeloF); // asociación Many To One
		cita2.setHairAssistance(cortePeloF);
		cita3.setHairAssistance(cortePeloM);
		appRepository.save(cita1);
		appRepository.save(cita2);
		appRepository.save(cita3);


		// EMPLOYEE
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		Employee emp1 = new Employee(null, "emp1", "emp1", "emp1@company.com", null, "12345", "8765674H");
		Employee emp2 = new Employee(null, "emp2", "emp2", "emp2@company.com", null, "12346", "8765674J");
		employeeRepository.save(emp1);
		employeeRepository.save(emp2);


		// APPOINTMENT - EMPLOYEE
		cita1.setEmployee(emp1);
		cita2.setEmployee(emp1);
		appRepository.saveAll(List.of(cita1, cita2));


		HairAssistance ha1 = new HairAssistance(null, "Corte pelo M", 15.0, 40);
		HairAssistance ha2 = new HairAssistance(null, "Corte pelo F", 30.0, 40);
		HairAssistance ha3 = new HairAssistance(null, "Corte pelo M advance", 20.0, 40);
		HairAssistance ha4 = new HairAssistance(null, "Corte pelo M san valentin", 20.0, 40);
		hairAssistRepository.save(ha1);
		hairAssistRepository.save(ha2);
		hairAssistRepository.save(ha3);
		hairAssistRepository.save(ha4);


		Customer customer3 = new Customer(null, "customer3", "lastname3", "customer3@example.com", null);
		customerRepository.save(customer3);

		Appointment app1 = new Appointment(null, LocalDateTime.of(2022, 1, 1, 13, 30), 50, "");
		app1.setHairAssistance(ha1);
		app1.setCustomer(customer3);
		appRepository.save(app1);

		Appointment app2 = new Appointment(null, LocalDateTime.of(2022, 1, 14, 16, 30), 50, "");
		app2.setHairAssistance(ha2);
		app2.setCustomer(customer);
		appRepository.save(app2);

		Appointment app3 = new Appointment(null, LocalDateTime.of(2022, 1, 31, 20, 30), 50, "");
		app3.setHairAssistance(ha3);
		app3.setCustomer(customer2);
		appRepository.save(app3);

		Appointment app4 = new Appointment(null, LocalDateTime.of(2022, 2, 14, 20, 30), 50, "");
		app4.setHairAssistance(ha4);
		appRepository.save(app4);

		// CONSULTAR DATOS CUSTOMER
//		Optional<Customer> customerOpt = customerRepository.findById(1L);
//		Customer customer1 = null;
//
//		if(customerOpt.isPresent()) {
//			customer1 = customerOpt.get();
//			System.out.println(customer1.getAppointments());
//		}

	}

}
