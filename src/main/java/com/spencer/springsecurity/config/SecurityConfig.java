package com.spencer.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable) // disable csrf token, can also use lambda expressions
                //  to authorize all requests
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                // enable form login form with default settings provided my spring
                .formLogin(Customizer.withDefaults())
                // to enable basic http authentication (REST Method)
                .httpBasic(Customizer.withDefaults());
        
        return http.build();
    }

}
