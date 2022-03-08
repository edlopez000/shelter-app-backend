package com.shelterapp.backend.security;

import com.shelterapp.backend.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

@Configuration
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        Assert.notNull(auth, "No authentication data provided");

        String username = auth.getPrincipal() + "";
        String password = auth.getCredentials() + "";

        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (!passwordEncoder().matches(password, user.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }

        if (!user.isEnabled()) {
            throw new DisabledException("User account is not active");
        }

        return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
    }
}
