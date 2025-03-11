package com.example.inventory_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll() // Allow public access to Swagger
                        .anyRequest().authenticated() // Require authentication for other requests
                )
                .httpBasic(withDefaults())  // Using basic authentication
                .formLogin(withDefaults())  // Form-based login, if applicable
                .csrf().disable();  // Disable CSRF protection for API endpoints

        return http.build();
    }
}




