package com.example.edustream_ums_auth_MS.config;

import com.example.edustream_lib_security.exception.CustomAccessDeniedHandler;
import com.example.edustream_lib_security.exception.CustomAuthenticationEntryPoint;
import com.example.edustream_lib_security.filter.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Setup
                .csrf(csrf -> csrf.disable())                  // Disable CSRF because we do not have a website yet

                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))        // We do not create sessions, we are stateless because of JWT

                // Exceptions
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                        .accessDeniedHandler(new CustomAccessDeniedHandler())
                )

                // Rules
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/login").permitAll()               // Rule 1: Allow unauthenticated access to /auth/** endpoints
                        .anyRequest().authenticated())                                  // Rule 2: Any other request must be authenticated

                // Filter Override
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);// Add before the default UsernamePasswordAuthenticationFilter

        return http.build();
    }
}
