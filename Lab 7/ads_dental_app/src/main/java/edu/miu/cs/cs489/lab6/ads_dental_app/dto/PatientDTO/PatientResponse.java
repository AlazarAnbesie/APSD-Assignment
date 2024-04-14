package edu.miu.cs.cs489.lab6.ads_dental_app.dto.PatientDTO;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;

public record PatientResponse(
        Long id,
        String name,
        String email,
        String phone,
        String username,
        String roleType,
        Address address,
        String dob
) {
}
