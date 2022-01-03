package com.example.barbershop;

import com.example.barbershop.entities.Appointment;
import com.example.barbershop.entities.Customer;
import com.example.barbershop.repository.AppointmentRepository;
import com.example.barbershop.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
				60);


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
		Appointment cita2 = new Appointment(null, LocalDateTime.now(), 60);
		appRepository.save(cita2);
		Appointment cita3 = new Appointment(null, LocalDateTime.now(), 60);
		appRepository.save(cita3);

		Customer customer2 = new Customer(null, "customer2", "lastname2", "customer2@example.com", null);
		customer2.getAppointments().add(cita2);
		customer2.getAppointments().add(cita3);
		customerRepository.save(customer2);


		// Proyecto BARBERSHOP. Tareas para realizar:
		// TODO - agregar campo description en la entidad Appointment
		// TODO - Crear la entidad HairAssistance que representa un servicio a realizar a un cliente (cortar el pelo, peinar, arreglar barba, teñir, etc.)
		// TODO - Asociación entidades Appointment y HairAssistance
		// TODO - Entidad Employee
		// TODO - Asociación entidades Appointment y Employee
		// TODO - Capa servicio para todas las entidades con métodos CRUD
		// TODO - Capa controlador para todas las entidades con métodos CRUD
		// TODO - Pruebas con Postman: Pruebas GET, POST, PUT, DELETE por entidad
		// TODO - Spring Test: Pruebas GET, POST, PUT, DELETE
		// TODO - crear métodos de búsqueda:
		//  	- buscar todos las citas a partir de un email de cliente




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
