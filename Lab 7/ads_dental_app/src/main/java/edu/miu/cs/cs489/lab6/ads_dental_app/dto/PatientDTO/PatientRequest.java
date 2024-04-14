package edu.miu.cs.cs489.lab6.ads_dental_app.dto.PatientDTO;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;

import java.time.LocalDate;

public record PatientRequest(
        String name,
        String email,
        String phone,
        String username,
        String password,
        String roleType,
        Address address,
        LocalDate dob
) {
}
