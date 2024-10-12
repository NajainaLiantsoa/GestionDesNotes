/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author najai
 */
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "num_etu", nullable = false, unique = true)
    private String numEtu;
    
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @Column(name = "prenom", nullable = false)
    private String prenom;
    
    @Column(name = "genre", nullable = false)
    private String genre;
    
    @Column(name = "dtn", nullable = false)
    private LocalDate dateNaissance;
    
    @ManyToOne
    @JoinColumn(name = "id_promotion")
    private Promotion promotion;
  

    // Getters et setters
public Etudiant() {
      
    }
    public Etudiant(Long id, String numEtu, String nom, String prenom, LocalDate dateNaissance, Promotion promotion) {
        this.id = id;
        this.numEtu = numEtu;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.promotion = promotion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumEtu() {
        return numEtu;
    }

    public void setNumEtu(String numEtu) {
        this.numEtu = numEtu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
    
    
    
}


