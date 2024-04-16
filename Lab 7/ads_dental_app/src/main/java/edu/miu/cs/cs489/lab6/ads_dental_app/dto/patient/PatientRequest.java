package edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.appointment.AppointmentRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;

import java.time.LocalDate;
import java.util.List;

public record PatientRequest(
        String name,
        String email,
        String phone,
        String username,
        String password,
        List<RoleRequest> roles,
        Address address,
        LocalDate dob,
        List<AppointmentRequest> appointments // we need this if we want to create a patient with appointments
) {
}
