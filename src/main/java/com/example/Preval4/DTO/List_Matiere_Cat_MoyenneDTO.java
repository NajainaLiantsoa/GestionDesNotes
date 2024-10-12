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
public class List_Matiere_Cat_MoyenneDTO {
    private Long etudiantId;
    private String etu;
    private String etudiantNom;
    private String etudiantPrenom;
    private Long semestreId;
    private String semestreNom;
    private String ue;
    private String intitule;
    private BigDecimal note;
    private BigDecimal credits;
    private String categorie;

    public List_Matiere_Cat_MoyenneDTO(Long etudiantId, String etu, String etudiantNom, String etudiantPrenom, Long semestreId, String semestreNom, String ue, String intitule, BigDecimal note, BigDecimal credits, String categorie) {
        this.etudiantId = etudiantId;
        this.etu = etu;
        this.etudiantNom = etudiantNom;
        this.etudiantPrenom = etudiantPrenom;
        this.semestreId = semestreId;
        this.semestreNom = semestreNom;
        this.ue = ue;
        this.intitule = intitule;
        this.note = note;
        this.credits = credits;
        this.categorie = categorie;
    }

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public String getEtu() {
        return etu;
    }

    public void setEtu(String etu) {
        this.etu = etu;
    }

    public String getEtudiantNom() {
        return etudiantNom;
    }

    public void setEtudiantNom(String etudiantNom) {
        this.etudiantNom = etudiantNom;
    }

    public String getEtudiantPrenom() {
        return etudiantPrenom;
    }

    public void setEtudiantPrenom(String etudiantPrenom) {
        this.etudiantPrenom = etudiantPrenom;
    }

    public Long getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }

    public String getSemestreNom() {
        return semestreNom;
    }

    public void setSemestreNom(String semestreNom) {
        this.semestreNom = semestreNom;
    }

    public String getUe() {
        return ue;
    }

    public void setUe(String ue) {
        this.ue = ue;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public void setCredits(BigDecimal credits) {
        this.credits = credits;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    
}
