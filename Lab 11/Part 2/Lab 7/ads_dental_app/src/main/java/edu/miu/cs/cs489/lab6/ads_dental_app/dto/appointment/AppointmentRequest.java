package edu.miu.cs.cs489.lab6.ads_dental_app.dto.appointment;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Surgery;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AppointmentRequest(
        LocalDateTime dateTime,
        Long patientId,
        Long doctorId,
        Long surgeryId
) {
}
