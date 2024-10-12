package com.example.Preval4.DTO;

import java.math.BigDecimal;
import java.sql.Date;

public class ReleveNoteSemDTO {
    private String etudiant_nom;
    private String semestre_nom;
    private BigDecimal moyenne_generale;
    private Long total_credit_obtenu;
    private String mention;
    private String resultat;

    public ReleveNoteSemDTO(String etudiant_nom, String semestre_nom, BigDecimal moyenne_generale, Long total_credit_obtenu, String mention, String resultat) {
        this.etudiant_nom = etudiant_nom;
        this.semestre_nom = semestre_nom;
        this.moyenne_generale = moyenne_generale;
        this.total_credit_obtenu = total_credit_obtenu;
        this.mention = mention;
        this.resultat = resultat;
    }

    public String getEtudiant_nom() {
        return etudiant_nom;
    }

    public void setEtudiant_nom(String etudiant_nom) {
        this.etudiant_nom = etudiant_nom;
    }


    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

   

    public String getSemestre_nom() {
        return semestre_nom;
    }

    public void setSemestre_nom(String semestre_nom) {
        this.semestre_nom = semestre_nom;
    }

    public BigDecimal getMoyenne_generale() {
        return moyenne_generale;
    }

    public void setMoyenne_generale(BigDecimal moyenne_generale) {
        this.moyenne_generale = moyenne_generale;
    }

    public Long getTotal_credit_obtenu() {
        return total_credit_obtenu;
    }

    public void setTotal_credit_obtenu(Long total_credit_obtenu) {
        this.total_credit_obtenu = total_credit_obtenu;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    
    

    
}
