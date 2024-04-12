package edu.miu.cs.cs489.lab6.ads_dental_app;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.*;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs489.lab6.ads_dental_app.service.AppointmentService;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class AdsDentalAppApplication implements CommandLineRunner {

	@Autowired
	AppointmentService appointmentService;
	@Autowired
	RoleRepository roleRepository;


	public static void main(String[] args) {
		SpringApplication.run(AdsDentalAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//creating roles and saving them to the database before the application starts
		roleRepository.save(new Role(1L, RoleType.OFFICE_MANAGER));
		roleRepository.save(new Role(2L, RoleType.DENTIST));
		roleRepository.save(new Role(3L, RoleType.PATIENT));

		//Creating office manager
		User user = new User(null, "mahe", "mahe@mahe.com","12346789", "mahe",
				"mahe", roleRepository.findById(1L).get());

		// Creating a dentist
		Dentist dentist = new Dentist("General",new ArrayList<>());
		dentist.setName("DrMahe");
		dentist.setEmail("drmahe@mahe.com");
		dentist.setPhone("123456789");
		dentist.setUsername("drmahe");
		dentist.setPassword("drmahe");
		dentist.setRole(roleRepository.findById(2L).get());

		// Creating a patient
		Patient patient = new Patient(new Address(null,"1000 N 4th St.","Fairfield","Iowa","52556"),
				LocalDate.of(1990,10,20), new ArrayList<>());
		patient.setName("Alazar");
		patient.setEmail("alazar@mahe.com");
		patient.setPhone("123456789");
		patient.setUsername("alazar");
		patient.setPassword("alazar");
		patient.setRole(roleRepository.findById(3L).get());

		// Creating surgery
		Surgery surgery = new Surgery(null,"Tooth removal",
				new Address(null,"1000 N 4th St.","Fairfield","Iowa","52556"),
				"123456789",new ArrayList<>());

		// Creating an appointment

		Appointment appointment = new Appointment(null,LocalDateTime.of(2024,10,14,14,30)
				,surgery,dentist,patient);
		appointmentService.create(appointment);

		// Printing out appointment
		System.out.println("Appointment created");
		Appointment savedAppointment = appointmentService.getAllAppointments().get(0);
		System.out.print("Dentist name:");
		System.out.println(savedAppointment.getDentist().getName());
		System.out.print("Patient id:");
		System.out.println(savedAppointment.getPatient().getId());
		System.out.print("Patient name:");
		System.out.println(savedAppointment.getPatient().getName());
		System.out.print("Appointment date:");
		System.out.println(savedAppointment.getAppointmentDate());
		System.out.print("Surgery number:");
		System.out.println(savedAppointment.getSurgery().getId());




	}

}


