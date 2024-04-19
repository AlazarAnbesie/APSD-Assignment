package edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

public record PatientResponse(
        Long id,
        String name,
        String email,
        String phone,
        String username,
        List<RoleResponse> roles,
        Address address,
        LocalDate dob
) {
}
