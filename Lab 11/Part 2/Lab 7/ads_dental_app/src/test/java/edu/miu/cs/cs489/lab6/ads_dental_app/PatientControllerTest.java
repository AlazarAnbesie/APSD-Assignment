package edu.miu.cs.cs489.lab6.ads_dental_app;

import edu.miu.cs.cs489.lab6.ads_dental_app.controller.PatientController;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.RoleType;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @MockBean
    private PatientService patientService;

    @Autowired
    MockMvc mock;

//    @BeforeEach
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
    // create
    @Test
    public void testRegisterPatient() throws Exception {
        PatientResponse patientResponse = new PatientResponse(1L, "John Doe", "john.doe@gmail.com",
                "6012310098", "johndoe", List.of(new RoleResponse(1L, RoleType.DENTIST)),
                new Address(1L, "123 N St.", "Lame", "Fairfield", "90919"), LocalDate.of(1996, 1, 1));
        Mockito.when(patientService.getAllPatients()).thenReturn(List.of(patientResponse));
        mock.perform(get("/adsweb/api/v1/patient/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("john.doe@gmail.com"));
    }

}
