package edu.miu.cs.cs489.lab6.ads_dental_app.service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;

import java.util.List;

public interface PatientService {
    public Patient create(Patient patient);

    public Patient read(Long id);

    public Patient update(Long id, Patient patient);

    public void delete(Long id);

    public List<Patient> getAllPatients();
}
