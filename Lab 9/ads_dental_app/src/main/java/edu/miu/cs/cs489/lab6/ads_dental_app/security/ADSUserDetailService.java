package edu.miu.cs.cs489.lab6.ads_dental_app.security;


import edu.miu.cs.cs489.lab6.ads_dental_app.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class ADSUserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    public ADSUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        edu.miu.cs.cs489.lab6.ads_dental_app.model.User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(String.valueOf(user.getRole())) // assuming getRoles() returns a list of roles
                .build();
    }
}
