package edu.miu.cs.cs489.lab6.ads_dental_app.dto.dentist;

public record DentistResponse(
        Long id,
        String name,
        String email,
        String phone,
        String username,
        String speciality
) {
}
