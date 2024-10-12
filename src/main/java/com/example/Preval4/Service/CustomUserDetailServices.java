/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Service;




import com.example.Preval4.Model.Users.Admin;
import com.example.Preval4.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author TOAVINA
 */
@Service
public class CustomUserDetailServices implements UserDetailsService{
    @Autowired
    private AdminRepository adminRepository;

   @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByLogin(login)
                                     .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + login));
        return new CustomUserDetail(admin);
    }
    
}
