package edu.miu.cs.cs489.lab6.ads_dental_app.service.impl;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.exception.PatientNotFoundException;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Role;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.PatientRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.RoleRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;

    RoleRepository roleRepository;

    @Override
    public PatientResponse create(PatientRequest patient) {
        Patient newPatient = new Patient();
        setValuesFromDTO(patient, newPatient);
        List<Role> roles = patient.roles().stream().map(roleRequest -> new Role(null, roleRequest.roleType(), null)).toList();
        newPatient.setRole(roles);
        Patient savedPatient = patientRepository.save(newPatient);
        return getPatientResponse(savedPatient);

    }

    @Override
    public PatientResponse read(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        return new PatientResponse(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getUsername(), patient.getRole().stream().map(role -> new RoleResponse(role.getId(), role.getRoleType())).toList(), patient.getAddress(), patient.getDob());
    }

    @Override
    public PatientResponse update(Long id, PatientRequest patient) {
        Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        setValuesFromDTO(patient, existingPatient);
        Patient savedPatient = patientRepository.save(existingPatient);
        return getPatientResponse(savedPatient);
    }


    @Override
    public void delete(Long id) {
        patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> new PatientResponse(patient.getId(), patient.getName(), patient.getEmail(),
                        patient.getPhone(), patient.getUsername(),
                        patient.getRole().stream()
                                .map(role -> new RoleResponse(role.getId(), role.getRoleType())).toList(),
                        patient.getAddress(), patient.getDob())).toList();
    }

    @Override
    public List<PatientResponse> search(String query) {
        return patientRepository.search(query).stream()
                .map(patient -> new PatientResponse(patient.getId(), patient.getName(), patient.getEmail(),
                        patient.getPhone(), patient.getUsername(), patient.getRole().stream()
                        .map(role -> new RoleResponse(role.getId(), role.getRoleType())).toList(),
                        patient.getAddress(), patient.getDob())).toList();
    }

    @Override
    public PatientResponse findPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        return new PatientResponse(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getUsername(), patient.getRole().stream().map(role -> new RoleResponse(role.getId(), role.getRoleType())).toList(), patient.getAddress(), patient.getDob());
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // helper methods to set values from DTO to entity and vice versa
    private void setValuesFromDTO(PatientRequest patientRequest, Patient patient) {
        patient.setName(patientRequest.name());
        patient.setEmail(patientRequest.email());
        patient.setPhone(patientRequest.phone());
        patient.setUsername(patientRequest.username());
        patient.setPassword(patientRequest.password());
        patient.setAddress(patientRequest.address());
        patient.setDob(patientRequest.dob());
    }

    private PatientResponse getPatientResponse(Patient patient) {
        return new PatientResponse(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getUsername(), patient.getRole().stream().map(role -> new RoleResponse(role.getId(), role.getRoleType())).toList(), patient.getAddress(), patient.getDob());
    }
}
