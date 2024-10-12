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
public class MoyenneNoteEtuDTO {
    private String semestre_nom;
    private String etu;
    private String resultat;
    private BigDecimal total_credit_obtenu;
    private BigDecimal moyenne_generale;
    private String mention;
    private Long rang ;
    private Long rang_global;

    public MoyenneNoteEtuDTO(String semestre_nom, String etu, String resultat, BigDecimal total_credit_obtenu, BigDecimal moyenne_generale, String mention, Long rang, Long rang_global) {
        this.semestre_nom = semestre_nom;
        this.etu = etu;
        this.resultat = resultat;
        this.total_credit_obtenu = total_credit_obtenu;
        this.moyenne_generale = moyenne_generale;
        this.mention = mention;
        this.rang = rang;
        this.rang_global = rang_global;
    }

    public Long getRang_global() {
        return rang_global;
    }

    public void setRang_global(Long rang_global) {
        this.rang_global = rang_global;
    }

  
    
    public String getSemestre_nom() {
        return semestre_nom;
    }

    public void setSemestre_nom(String semestre_nom) {
        this.semestre_nom = semestre_nom;
    }

    

    public Long getRang() {
        return rang;
    }

    public void setRang(Long rang) {
        this.rang = rang;
    }
    
    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }


    

    public String getEtu() {
        return etu;
    }

    public void setEtu(String etu) {
        this.etu = etu;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public BigDecimal getTotal_credit_obtenu() {
        return total_credit_obtenu;
    }

    public void setTotal_credit_obtenu(BigDecimal total_credit_obtenu) {
        this.total_credit_obtenu = total_credit_obtenu;
    }

    public BigDecimal getMoyenne_generale() {
        return moyenne_generale;
    }

    public void setMoyenne_generale(BigDecimal moyenne_generale) {
        this.moyenne_generale = moyenne_generale;
    }

    
    
    
    
    
}
