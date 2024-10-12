/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.DTO;

import java.math.BigDecimal;

/**
 *
 * @author najai
 */
public class MoyenneAnneeDTO {
    private Long id_etud;
    private String nom;
    private String prenom;
    private Long annee;
   private BigDecimal moyenne;

    public MoyenneAnneeDTO(Long id_etud, String nom, String prenom, Long annee, BigDecimal moyenne) {
        this.id_etud = id_etud;
        this.nom = nom;
        this.prenom = prenom;
        this.annee = annee;
        this.moyenne = moyenne;
    }

    public Long getId_etud() {
        return id_etud;
    }

    public void setId_etud(Long id_etud) {
        this.id_etud = id_etud;
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

    public Long getAnnee() {
        return annee;
    }

    public void setAnnee(Long annee) {
        this.annee = annee;
    }

    public BigDecimal getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(BigDecimal moyenne) {
        this.moyenne = moyenne;
    }

   
   
    
}
