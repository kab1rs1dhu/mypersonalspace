package com.mypersonalspace.mypersonalspace.Security;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SuppressWarnings({ "deprecation", "removal" })
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        try{

            http.csrf(customizer -> customizer.disable());
            http.authorizeRequests(request -> request.anyRequest().permitAll());

            http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            return http.build();
        }
        catch(Exception e){
            // error occured
            return null;
        }
    }


    
}