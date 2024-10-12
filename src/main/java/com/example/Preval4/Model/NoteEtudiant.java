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
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author najai
 * 
 */@Entity

public class NoteEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false)
    private BigDecimal note;

    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private Matiere matiere;

    // Getters et setters

    public NoteEtudiant(Long id, BigDecimal note, Etudiant etudiant, Matiere matiere) {
        this.id = id;
        this.note = note;
        this.etudiant = etudiant;
        this.matiere = matiere;
    }

    public NoteEtudiant() {
       }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

   

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    
    
}

