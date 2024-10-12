/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Config;

import com.example.Preval4.Service.CustomSuccessHandler;
import com.example.Preval4.Service.CustomUserDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;






@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailServices customUserDetailServices;
    
    @Autowired
    private CustomSuccessHandler customSucceessHandler;
    
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable())
        
        .authorizeHttpRequests(request -> request.requestMatchers("/home-page")
            .permitAll().requestMatchers("/admin/**").hasAuthority("admin")
            .anyRequest().permitAll())
        
        .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
            .successHandler(customSucceessHandler).permitAll())
                
        .logout(form -> form.invalidateHttpSession(true).clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login_client?logout").permitAll());
        
        return http.build();
    }
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailServices).passwordEncoder(passwordEncoder());
    }
    
    
   
}
