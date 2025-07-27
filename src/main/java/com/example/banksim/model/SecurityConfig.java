package com.example.banksim.model;

import com.example.banksim.repository.UserRoles;
import com.example.banksim.service.IInitRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    IInitRolesService initRolesService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/public/**").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/account")
                        .failureUrl("/login?error") // Redirect after failed login
                        .permitAll()) // Enables form-based login
                .httpBasic(Customizer.withDefaults()); // Enables HTTP Basic authentication
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Example with in-memory users
        List<UserRoles> Roles = initRolesService.getRoles();

        List<UserDetails> listUser = new ArrayList<>();
        for (UserRoles role: Roles){
            listUser.add( User.withDefaultPasswordEncoder()
              .username(role.getUsername())
                .password(role.getPassword())
                .roles(role.getRole())
                .build());
        }
        return new InMemoryUserDetailsManager(listUser);
    }
}
