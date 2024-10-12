/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Model.Temp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

/**
 *
 * @author najai
 */

@Entity
@Table(name = "note_temp")
public class NoteTemp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = false)
    private String numetu;
    
    @Column(unique = false)
    private String nom;
    
    @Column(unique = false)
    private String prenom;
    
    @Column(unique = false)
    private String genre;
    
    @Column(unique = false)
    private Date datenaissance;
    
    @Column(unique = false)
    private String promotion;
    
    @Column(unique = false)
    private String codematiere;
    
    @Column(unique = false)
    private String semestre;
    
    @Column(unique = false)
    private double note;

    public NoteTemp(Long id, String numetu, String nom, String prenom, String genre, Date datenaissance, String promotion, String codematiere, String semestre, double note) {
        this.id = id;
        this.numetu = numetu;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.datenaissance = datenaissance;
        this.promotion = promotion;
        this.codematiere = codematiere;
        this.semestre = semestre;
        this.note = note;
    }

    NoteTemp() {
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumetu() {
        return numetu;
    }

    public void setNumetu(String numetu) {
        this.numetu = numetu;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getCodematiere() {
        return codematiere;
    }

    public void setCodematiere(String codematiere) {
        this.codematiere = codematiere;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    
    
    
    
}
