package com.example.DiagnoShare.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF (Cross-Site Request Forgery)
                // We disable this because we are building a stateless REST API, not a traditional web form.
                .csrf(csrf -> csrf.disable())

                // 2. Configure our API access rules
                .authorizeHttpRequests(auth -> auth
                        // Allow anyone on the internet to hit the register endpoint
                        .requestMatchers("/api/users/register").permitAll()
                        .requestMatchers("/api/reports/**").permitAll()
                        // Any other request must be logged in
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}