package edu.miu.cs.cs489.lab6.ads_dental_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.name LIKE %?1% OR p.email LIKE %?1% OR p.phone LIKE %?1% " +
            "OR p.address.state LIKE %?1%" + "OR p.address.city LIKE %?1%" + "OR p.address.street LIKE %?1%"
            + "OR p.address.zipCode LIKE %?1%")
    public List<Patient> search(String query);
}