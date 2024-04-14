package edu.miu.cs.cs489.lab6.ads_dental_app.service.impl;

import edu.miu.cs.cs489.lab6.ads_dental_app.exception.PatientNotFoundException;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Role;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.PatientRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;

    RoleRepository roleRepository;

    @Override
    public Patient create(Patient patient) {
        Role role = roleRepository.findRoleByRoleType(patient.getRole().getRoleType()).orElse(null);
        patient.setRole(role);
        return patientRepository.save(patient);
    }

    @Override
    public Patient read(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
    }

    @Override
    public Patient update(Long id, Patient patient) {
        Patient patientToUpdate = patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("Patient not found"));
        patientToUpdate.setName(patient.getName());
        patientToUpdate.setEmail(patient.getEmail());
        patientToUpdate.setPhone(patient.getPhone());
        patientToUpdate.setAddress(patient.getAddress());
        patientToUpdate.setDob(patient.getDob());
        patientToUpdate.setUsername(patient.getUsername());
        patientToUpdate.setPassword(patient.getPassword());
        return patientRepository.save(patientToUpdate);
    }

    @Override
    public void delete(Long id) {
        patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        patientRepository.deleteById(id);
    }


    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> search(String query) {
        return patientRepository.search(query);
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


}
