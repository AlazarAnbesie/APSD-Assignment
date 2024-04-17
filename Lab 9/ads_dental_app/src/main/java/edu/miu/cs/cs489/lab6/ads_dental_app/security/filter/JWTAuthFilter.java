package edu.miu.cs.cs489.lab6.ads_dental_app.security.filter;

import edu.miu.cs.cs489.lab6.ads_dental_app.security.ADSUserDetailService;
import edu.miu.cs.cs489.lab6.ads_dental_app.security.utils.JWTManagementUtilityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    private ADSUserDetailService adsUserDetailService;
    private JWTManagementUtilityService jwtManagementUtilityService;

    public JWTAuthFilter(ADSUserDetailService adsUserDetailService, JWTManagementUtilityService jwtManagementUtilityService) {
        this.adsUserDetailService = adsUserDetailService;
        this.jwtManagementUtilityService = jwtManagementUtilityService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            username = jwtManagementUtilityService.extractUsername(token);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = adsUserDetailService.loadUserByUsername(username);
            if (jwtManagementUtilityService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
