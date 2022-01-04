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
		appRepository.save(cita1);
		appRepository.save(cita2);


		// EMPLOYEE
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		Employee emp1 = new Employee(null, "emp1", "emp1", "emp1@company.com", null, "12345", "8765674H");
		employeeRepository.save(emp1);

		// APPOINTMENT - EMPLOYEE
		cita1.setEmployee(emp1);
		cita2.setEmployee(emp1);
		appRepository.saveAll(List.of(cita1, cita2));



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
