package edu.miu.cs.cs489.lab6.ads_dental_app;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.exception.PatientNotFoundException;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Role;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.RoleType;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.PatientRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PatientServiceTest {

    @MockBean
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPatientById() {
        PatientResponse patientResponse = new PatientResponse(1L, "John Doe", "john.doe@gmail.com",
                "6012310098", "johndoe", List.of(new RoleResponse(1L, RoleType.DENTIST)),
                new Address(1L, "123 N St.", "Lame", "Fairfield", "90919"), LocalDate.of(1996, 1, 1));
        Patient patient = new Patient(new Address(1L, "123 N St.", "Lame", "Fairfield", "90919"), LocalDate.of(1996, 1, 1), null);
        patient.setId(1L);
        patient.setName("John Doe");
        patient.setEmail("john.doe@gmail.com");
        patient.setPhone("6012310098");
        patient.setUsername("johndoe");
        patient.setRole(List.of(new Role(1L, RoleType.DENTIST, null)));
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
        var patientRes = patientService.findPatientById(1L);
        assertEquals(patientResponse, patientRes);
        verify(patientRepository).findById(1L);
    }

    @Test
    public void testFindPatientByIdInvalid() {
        when(patientRepository.findById(1L)).thenThrow(new PatientNotFoundException("Patient not found"));
        assertThrows(PatientNotFoundException.class, () -> {
            patientService.findPatientById(1L);
        });
    }
}
