package com.example.Preval4.Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




import com.example.Preval4.Service.CustomUserDetailServices;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 */
@Controller
public class Authen { 
    @Autowired
    private CustomUserDetailServices customUserDetailServices;
    
    
    @GetMapping("/login_etudiant")
    public String login1() {
        return "Login_Ad_1";
    }
    
    @GetMapping("/login_admin")
    public String login3() {
        return "Login_Ad";
    }
    
    @GetMapping("/test")
    public String login4() {
        return "index";
    }
    
    
    @GetMapping("/welcome")
    public String welcome(Model model, Principal principal) {
        UserDetails userDetails = customUserDetailServices.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "welcome";
    }
}
