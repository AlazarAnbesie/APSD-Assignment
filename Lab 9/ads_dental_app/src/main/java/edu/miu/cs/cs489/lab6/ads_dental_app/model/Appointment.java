package edu.miu.cs.cs489.lab6.ads_dental_app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "appointment date time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime appointmentDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
