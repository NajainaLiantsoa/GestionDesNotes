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
import java.io.Serializable;

/**
 *
 * @author najai
 */


@Entity
public class Matiere {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "code_matiere", nullable = false, length = 100)
    private String codeMatiere;

    @Column(name = "credit", nullable = false)
    private int credit;

    @ManyToOne
    @JoinColumn(name = "id_semestre", nullable = true)
    private Semestre semestre;

    // Constructeurs
    public Matiere() {}

    public Matiere(String nom, String codeMatiere, int credit, Semestre semestre) {
        this.nom = nom;
        this.codeMatiere = codeMatiere;
        this.credit = credit;
        this.semestre = semestre;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}


