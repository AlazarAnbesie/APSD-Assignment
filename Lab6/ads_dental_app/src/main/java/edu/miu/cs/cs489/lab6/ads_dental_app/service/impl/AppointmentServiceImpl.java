package edu.miu.cs.cs489.lab6.ads_dental_app.service.impl;

import edu.miu.cs.cs489.lab6.ads_dental_app.repository.DentistRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Appointment;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.AppointmentRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.AppointmentService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    AppointmentRepository appointmentRepository;

    PatientRepository patientRepository;

    DentistRepository dentistRepository;

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment read(Long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        Appointment appointmentToUpdate = appointmentRepository.findById(id).get();
        appointmentToUpdate.setAppointmentDate(appointment.getAppointmentDate());
        appointmentToUpdate.setSurgery(appointment.getSurgery());
        appointmentToUpdate.setDentist(appointment.getDentist());
        appointmentToUpdate.setPatient(appointment.getPatient());
        return appointmentRepository.save(appointmentToUpdate);

    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }


    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    @Autowired
    public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    public void setDentistRepository(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

}
