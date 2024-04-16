package edu.miu.cs.cs489.lab6.ads_dental_app.dto.appointment;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.dentist.DentistResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.surgery.SurgeryResponse;

import java.time.LocalDateTime;

public record AppointmentResponse(
        Long id,
        LocalDateTime dateTime,
        PatientResponse patient,
        DentistResponse doctor,
        SurgeryResponse surgery) {
}
