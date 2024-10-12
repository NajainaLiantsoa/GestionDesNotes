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
public class MoyenneNoteDTO {
    private String etu;
    private String resultat;
    private BigDecimal total_credit_obtenu;
    private BigDecimal moyenne_generale;
    private String mention;

    public MoyenneNoteDTO(String etu, String resultat, BigDecimal total_credit_obtenu, BigDecimal moyenne_generale, String mention) {
        this.etu = etu;
        this.resultat = resultat;
        this.total_credit_obtenu = total_credit_obtenu;
        this.moyenne_generale = moyenne_generale;
        this.mention = mention;  

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
