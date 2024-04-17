package edu.miu.cs.cs489.lab6.ads_dental_app.dto.surgery;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.appointment.AppointmentResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.model.Address;

import java.util.List;

public record SurgeryResponse(
        Long id,
        String name,
        Address location,
        String phone
) {
}
