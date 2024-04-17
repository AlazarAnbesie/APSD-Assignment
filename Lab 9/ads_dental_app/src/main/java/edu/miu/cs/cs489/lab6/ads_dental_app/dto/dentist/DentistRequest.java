package edu.miu.cs.cs489.lab6.ads_dental_app.dto.dentist;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleRequest;

import java.util.List;

public record DentistRequest(
        String name,
        String email,
        String phone,
        String username,
        String password,
        List<RoleRequest> roles,
        String speciality

) {
}
