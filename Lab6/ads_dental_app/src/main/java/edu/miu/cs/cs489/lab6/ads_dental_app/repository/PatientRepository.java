package edu.miu.cs.cs489.lab6.ads_dental_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}