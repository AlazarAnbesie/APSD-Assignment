package edu.miu.cs.cs489.lab6.ads_dental_app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.PatientRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.PatientService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;

    @Override
    public Patient create(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient read(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient update(Long id, Patient patient) {
        Patient patientToUpdate = patientRepository.findById(id).get();
        patientToUpdate.setName(patient.getName());
        patientToUpdate.setEmail(patient.getEmail());
        patientToUpdate.setPhone(patient.getPhone());
        patientToUpdate.setAddress(patient.getAddress());
        return patientRepository.save(patientToUpdate);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }


    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


}
