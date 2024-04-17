package edu.miu.cs.cs489.lab6.ads_dental_app.security;


import edu.miu.cs.cs489.lab6.ads_dental_app.dto.patient.PatientResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.role.RoleResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.dto.user.UserResponse;
import edu.miu.cs.cs489.lab6.ads_dental_app.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

@Service
public class ADSUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    public ADSUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userFromDB = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserResponse user = new UserResponse(userFromDB.getId(), userFromDB.getName(), userFromDB.getUsername(),userFromDB.getPassword(),
                userFromDB.getEmail(), userFromDB.getPhone(), userFromDB.getRole().stream().map(role->{
                return new RoleResponse(role.getId(), role.getRoleType());
        }).toList());


        return User.withUsername(user.username())
                .password(user.password())
                .roles(String.valueOf(user.roles())) // assuming getRoles() returns a list of roles
                .build();
    }
}
