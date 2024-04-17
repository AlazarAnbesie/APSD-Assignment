package edu.miu.cs.cs489.lab6.ads_dental_app;

import edu.miu.cs.cs489.lab6.ads_dental_app.model.Appointment;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.AppointmentRepository;
import edu.miu.cs.cs489.lab6.ads_dental_app.service.impl.AppointmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AppointmentServiceImplTest {

    @InjectMocks
    AppointmentServiceImpl appointmentService;

    @Mock
    AppointmentRepository appointmentRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = new Appointment();
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);
        Appointment created = appointmentService.create(appointment);
        assertEquals(created, appointment);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    public void testReadAppointment() {
        Appointment appointment = new Appointment();
        when(appointmentRepository.findById(any(Long.class))).thenReturn(Optional.of(appointment));
        Appointment read = appointmentService.read(1L);
        assertEquals(read, appointment);
        verify(appointmentRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdateAppointment() {
        Appointment appointment = new Appointment();
        when(appointmentRepository.findById(any(Long.class))).thenReturn(Optional.of(appointment));
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);
        Appointment updated = appointmentService.update(1L, appointment);
        assertEquals(updated, appointment);
        verify(appointmentRepository, times(1)).findById(1L);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    public void testDeleteAppointment() {
        doNothing().when(appointmentRepository).deleteById(any(Long.class));
        appointmentService.delete(1L);
        verify(appointmentRepository, times(1)).deleteById(1L);
    }
}