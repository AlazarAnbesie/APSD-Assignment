package edu.miu.cs.cs489.lab6.ads_dental_app.controller;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {

    PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<PatientResponse> registerPatient(@RequestBody @Valid PatientRequest patient) {
        return ResponseEntity.ok(patientService.create(patient));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id, @RequestBody @Valid PatientRequest patient) {
        return ResponseEntity.ok(patientService.update(id, patient));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.read(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<PatientResponse>> getPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/search")
    public ResponseEntity<List<PatientResponse>> searchPatients(@RequestParam String query) {
        return ResponseEntity.ok(patientService.search(query));
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

}
