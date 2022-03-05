package com.shelterapp.backend.security;

import com.shelterapp.backend.service.CustomUserDetailsService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;
    private final CustomAuthenticationManager customAuthenticationManager;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService, CustomAuthenticationManager customAuthenticationManager) {
        this.userDetailsService = userDetailsService;
        this.customAuthenticationManager = customAuthenticationManager;
    }

    @Bean
    PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(@NotNull HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/error").permitAll()
                .antMatchers("/animals").permitAll()
                .antMatchers("/animals/**").permitAll()
                .antMatchers("/volunteers").permitAll()
                .antMatchers("/session/**").permitAll()
                // Other routes will be added here like for example:
                // .antMatchers("/api/animals/**").hasRole("ROLE_USER")
                // This will ensure that the API is only available to registered users
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.parentAuthenticationManager(customAuthenticationManager)
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoderBean());
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}