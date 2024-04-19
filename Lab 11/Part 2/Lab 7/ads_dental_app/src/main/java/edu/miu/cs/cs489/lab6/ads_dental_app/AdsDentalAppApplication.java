package edu.miu.cs.cs489.lab6.ads_dental_app;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Role;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.RoleType;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AdsDentalAppApplication implements CommandLineRunner {
//	@Autowired
//	RoleRepository roleRepository;
//	@Autowired
//	RestTemplate restTemplate;
//	String url = "http://localhost:8080/adsweb/api/v1/patient";
	public static void main(String[] args) {
		SpringApplication.run(AdsDentalAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server is running...");
//		// Here the server is acting as a client to itself
//		// CRUD operations
//
//		// Create ------------------------------------------------ //
//		RoleRequest roleRequest = new RoleRequest(RoleType.PATIENT);
//		PatientRequest patientRequest = new PatientRequest("John Doe", "johndoe@gmail.com", "4140941111",
//				"johndoe", "password", List.of(roleRequest),
//				new Address(null,"123 Lame St.","Lame","IA","10101"),
//				LocalDate.of(1979, 1, 1),null);
//		PatientResponse patientResponse = restTemplate.postForObject(url+"/register", patientRequest, PatientResponse.class);
//		System.out.println("Created patient: " + patientResponse);
//		//--------------------------------------------------------- //
//
//		// Read  ------------------------------------------------ //
//		PatientResponse patientResponse1 = restTemplate.getForObject(url + "/get/" + patientResponse.id(), PatientResponse.class);
//		System.out.println("Read patient: " + patientResponse1);
//		//--------------------------------------------------------- //
//
//		// Update ---------------------------------------------- //
//		PatientRequest updatedPatient = new PatientRequest("Trevor Doe", "trevor@gmail.com", "1231549099",
//				"trevor", "password", List.of(roleRequest),
//				new Address(null,"1000 N 4th St.","Lame","IA","52557"),
//				LocalDate.of(1979, 1, 23),null);
//		restTemplate.put(url + "/update/" + patientResponse.id(), updatedPatient);
//		PatientResponse updatedPatientResponse = restTemplate.getForObject(url + "/get/" + patientResponse.id(), PatientResponse.class);
//		System.out.println("Updated patient: " + updatedPatientResponse);
//		//--------------------------------------------------------- //
//
//		// get all patients ------------------------------------- //
//		PatientResponse[] patientResponses = restTemplate.getForObject(url + "/list", PatientResponse[].class);
//		System.out.println("All patients: ");
//		for (PatientResponse p : patientResponses) {
//			System.out.println(p);
//		}
//		//--------------------------------------------------------- //
//
//		// search ----------------------------------------------- //
//		PatientResponse[] searchResults = restTemplate.getForObject(url + "/search?query=Lame", PatientResponse[].class);
//		System.out.println("Search results: ");
//		for (PatientResponse p : searchResults) {
//			System.out.println(p);
//		}
//		//--------------------------------------------------------- //
//
//		// Delete
//		restTemplate.delete(url + "/delete/" + updatedPatientResponse.id());
//		System.out.println("Patient Deleted");
//	}
//
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	}
}


