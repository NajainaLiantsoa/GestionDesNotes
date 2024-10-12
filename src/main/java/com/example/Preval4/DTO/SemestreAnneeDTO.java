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
public class SemestreAnneeDTO {
    private String etudiant_nom;
    private String etudiant_prenom;

    private String nom_semestre;
    private String ue;
    private String intitule;
    private Long credit;
    private BigDecimal note;
    private String resultat;
    private int annee;

   

    public SemestreAnneeDTO(String etudiant_nom, String etudiant_prenom, String nom_semestre, String ue, String intitule, Long credit, BigDecimal note, String resultat, int annee) {
        this.etudiant_nom = etudiant_nom;
        this.etudiant_prenom = etudiant_prenom;
        this.nom_semestre = nom_semestre;
        this.ue = ue;
        this.intitule = intitule;
        this.credit = credit;
        this.note = note;
        this.resultat = resultat;
        this.annee = annee;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    

    public String getEtudiant_nom() {
        return etudiant_nom;
    }

    public void setEtudiant_nom(String etudiant_nom) {
        this.etudiant_nom = etudiant_nom;
    }

    public String getEtudiant_prenom() {
        return etudiant_prenom;
    }

    public void setEtudiant_prenom(String etudiant_prenom) {
        this.etudiant_prenom = etudiant_prenom;
    }

   

    public String getNom_semestre() {
        return nom_semestre;
    }

    public void setNom_semestre(String nom_semestre) {
        this.nom_semestre = nom_semestre;
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

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    

    
    
}
