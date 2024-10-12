/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.DTO;

/**
 *
 * @author najai
 */
public class MatiereAjourneeDTO {
    String semestre_nom;
    String ue;
    String matiere;
    Long note;
    Long montant_rattrapage;

    public MatiereAjourneeDTO(String semestre_nom, String ue, String matiere, Long note, Long montant_rattrapage) {
        this.semestre_nom = semestre_nom;
        this.ue = ue;
        this.matiere = matiere;
        this.note = note;
        this.montant_rattrapage = montant_rattrapage;
    }

    public String getSemestre_nom() {
        return semestre_nom;
    }

    public void setSemestre_nom(String semestre_nom) {
        this.semestre_nom = semestre_nom;
    }

    public String getUe() {
        return ue;
    }

    public void setUe(String ue) {
        this.ue = ue;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Long getNote() {
        return note;
    }

    public void setNote(Long note) {
        this.note = note;
    }

    public Long getMontant_rattrapage() {
        return montant_rattrapage;
    }

    public void setMontant_rattrapage(Long montant_rattrapage) {
        this.montant_rattrapage = montant_rattrapage;
    }
    
    
}
