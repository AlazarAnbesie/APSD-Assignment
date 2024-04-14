package edu.miu.cs.cs489.lab6.ads_dental_app.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    @Size(min = 3, max = 50)
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Email is required")
    @Size(min = 3, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotNull(message = "Phone is required")
    @Size(min = 10, max = 15)
    @Pattern(regexp = "^[0-9]*$")
    private String phone;
    @NotNull(message = "Username is required")
    @Size(min = 3, max = 50)
    private String username;
    @NotNull(message = "Password is required")
    @Size(min = 6, max = 16)
    private String password;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "role_id")
    private Role role;
}
