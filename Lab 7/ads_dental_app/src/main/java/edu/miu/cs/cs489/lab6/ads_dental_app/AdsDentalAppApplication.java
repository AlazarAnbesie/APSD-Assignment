package edu.miu.cs.cs489.lab6.ads_dental_app;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Role;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.RoleType;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdsDentalAppApplication implements CommandLineRunner {
	@Autowired
	RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(AdsDentalAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		roleRepository.save(new Role(1L, RoleType.OFFICE_MANAGER));
		roleRepository.save(new Role(2L, RoleType.DENTIST));
		roleRepository.save(new Role(3L, RoleType.PATIENT));

		System.out.println("Server is running...");
	}
}


