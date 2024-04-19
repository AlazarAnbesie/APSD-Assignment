package edu.miu.cs.cs489.lab6.ads_dental_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentists")
public class Dentist extends User {
    @Column(name = "specialization")
    private String specialization;
    @OneToMany(mappedBy = "dentist",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Appointment> appointments;

}
