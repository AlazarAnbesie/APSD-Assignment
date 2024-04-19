package edu.miu.cs.cs489.lab6.ads_dental_app.service;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;

import java.util.List;

public interface PatientService {
    public PatientResponse create(PatientRequest patient);

    public PatientResponse read(Long id);

    public PatientResponse update(Long id, PatientRequest patient);

    public void delete(Long id);

    public List<PatientResponse> getAllPatients();

    public List<PatientResponse> search(String query);

    public PatientResponse findPatientById(Long id);
}
