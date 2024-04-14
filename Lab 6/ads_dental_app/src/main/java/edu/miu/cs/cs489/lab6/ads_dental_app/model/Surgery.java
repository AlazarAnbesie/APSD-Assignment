package edu.miu.cs.cs489.lab6.ads_dental_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "surgeries")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address location;
    private String phone;
    @OneToMany(mappedBy = "surgery",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Appointment> appointments;
}
