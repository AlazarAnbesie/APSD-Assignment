package edu.miu.cs.cs489.lab6.ads_dental_app.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient extends User {
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private LocalDate dob;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Appointment> appointments;
}
