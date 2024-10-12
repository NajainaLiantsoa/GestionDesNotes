package com.example.Preval4.DTO;

import java.math.BigDecimal;
import java.sql.Date;

public class ReleveNoteDTO {
     private Long etudiantId;
    private String etu;
    private String etudiantNom;
    private String etudiantPrenom;
    private Long semestreId;
    private String semestreNom;
    private String intitule;
    private String ue;
    private BigDecimal creditObtenu;
    private BigDecimal note;
    private String resultat;

    public ReleveNoteDTO(Long etudiantId, String etu, String etudiantNom, String etudiantPrenom, Long semestreId, String semestreNom, String intitule, String ue, BigDecimal creditObtenu, BigDecimal note, String resultat) {
        this.etudiantId = etudiantId;
        this.etu = etu;
        this.etudiantNom = etudiantNom;
        this.etudiantPrenom = etudiantPrenom;
        this.semestreId = semestreId;
        this.semestreNom = semestreNom;
        this.intitule = intitule;
        this.ue = ue;
        this.creditObtenu = creditObtenu;
        this.note = note;
        this.resultat = resultat;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
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

    public BigDecimal getCreditObtenu() {
        return creditObtenu;
    }

    public void setCreditObtenu(BigDecimal creditObtenu) {
        this.creditObtenu = creditObtenu;
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
