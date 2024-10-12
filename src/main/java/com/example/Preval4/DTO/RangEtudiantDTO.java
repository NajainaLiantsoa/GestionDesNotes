package com.example.Preval4.DTO;



import java.math.BigDecimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author najai
 */
public class RangEtudiantDTO {
     private String etu;
    private String etudiantNom;
    private String etudiantPrenom;
    private Long semestreId;
    private String semestreNom;
    private BigDecimal moyenneGenerale;
    private int totalCreditObtenu;
    private String resultat;
    private String mention;
    private int rang;

    public RangEtudiantDTO(String etu, String etudiantNom, String etudiantPrenom, Long semestreId, String semestreNom, BigDecimal moyenneGenerale, int totalCreditObtenu, String resultat, String mention, int rang) {
        this.etu = etu;
        this.etudiantNom = etudiantNom;
        this.etudiantPrenom = etudiantPrenom;
        this.semestreId = semestreId;
        this.semestreNom = semestreNom;
        this.moyenneGenerale = moyenneGenerale;
        this.totalCreditObtenu = totalCreditObtenu;
        this.resultat = resultat;
        this.mention = mention;
        this.rang = rang;
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

    public BigDecimal getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public void setMoyenneGenerale(BigDecimal moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }

    public int getTotalCreditObtenu() {
        return totalCreditObtenu;
    }

    public void setTotalCreditObtenu(int totalCreditObtenu) {
        this.totalCreditObtenu = totalCreditObtenu;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
    
    
}
