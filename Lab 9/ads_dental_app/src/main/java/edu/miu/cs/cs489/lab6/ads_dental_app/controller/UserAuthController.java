package edu.miu.cs.cs489.lab6.ads_dental_app.controller;

import edu.miu.cs.cs489.lab6.ads_dental_app.dto.userAuth.UserAuthRequest;
import edu.miu.cs.cs489.lab6.ads_dental_app.security.utils.JWTManagementUtilityService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {
    private final JWTManagementUtilityService jwtManagementUtilityService;
    private final AuthenticationManager authenticationManager;

    public UserAuthController(JWTManagementUtilityService jwtManagementUtilityService, AuthenticationManager authenticationManager) {
        this.jwtManagementUtilityService = jwtManagementUtilityService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception{
         try {
             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthRequest.getUsername(), userAuthRequest.getPassword()));
         }
            catch (Exception e) {
                throw new Exception("Invalid username or password");
            }
        return jwtManagementUtilityService.generateToken(userAuthRequest.getUsername());
    }
}
