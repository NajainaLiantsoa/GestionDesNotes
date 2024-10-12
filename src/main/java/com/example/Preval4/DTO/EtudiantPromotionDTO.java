/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.DTO;

import java.util.Date;

/**
 *
 * @author najai
 */
public class EtudiantPromotionDTO {
    private Long etudiantId;
    private String numEtu;
    private String nom;
    private String prenom;
    private Date dtn;
    private String promotion_nom;

    // Constructeurs
    public EtudiantPromotionDTO() {}

    public EtudiantPromotionDTO(Long etudiantId, String numEtu, String nom, String prenom, Date dtn, String promotion_nom) {
        this.etudiantId = etudiantId;
        this.numEtu = numEtu;
        this.nom = nom;
        this.prenom = prenom;
        this.dtn = dtn;
        this.promotion_nom = promotion_nom;
    }

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
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

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    public String getPromotionNom() {
        return promotion_nom;
    }

    public void setPromotionNom(String promotion_nom) {
        this.promotion_nom = promotion_nom;
    }
    
    
    
}
