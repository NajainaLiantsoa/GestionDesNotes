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
public class MoyenneParCategorieDTO {
    private Long etudiantId;
    private String etu;
    private String etudiantNom;
    private String etudiantPrenom;
    private Long semestreId;
    private String semestreNom;
    private String categorie;
    private Integer nombreMatieres;
    private BigDecimal moyennePonderee;

    // Constructeur
    public MoyenneParCategorieDTO(Long etudiantId, String etu, String etudiantNom, String etudiantPrenom, 
                                  Long semestreId, String semestreNom, String categorie, 
                                  Integer nombreMatieres, BigDecimal moyennePonderee) {
        this.etudiantId = etudiantId;
        this.etu = etu;
        this.etudiantNom = etudiantNom;
        this.etudiantPrenom = etudiantPrenom;
        this.semestreId = semestreId;
        this.semestreNom = semestreNom;
        this.categorie = categorie;
        this.nombreMatieres = nombreMatieres;
        this.moyennePonderee = moyennePonderee;
    }

    // Getters et Setters
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getNombreMatieres() {
        return nombreMatieres;
    }

    public void setNombreMatieres(Integer nombreMatieres) {
        this.nombreMatieres = nombreMatieres;
    }

    public BigDecimal getMoyennePonderee() {
        return moyennePonderee;
    }

    public void setMoyennePonderee(BigDecimal moyennePonderee) {
        this.moyennePonderee = moyennePonderee;
    }
}
