package edu.miu.cs.cs489.lab6.ads_dental_app.service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Appointment;

import java.util.List;

public interface AppointmentService {
    public Appointment create(Appointment appointment);

    public Appointment read(Long id);

    public Appointment update(Long id, Appointment appointment);

    public void delete(Long id);

    public List<Appointment> getAllAppointments();

    
}
