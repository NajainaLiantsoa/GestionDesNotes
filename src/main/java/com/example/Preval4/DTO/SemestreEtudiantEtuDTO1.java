/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.DTO;

/**
 *
 * @author najai
 */
public class SemestreEtudiantEtuDTO1 { 
    private String etu;
    private String nomEtudiant;
    private Long idSemestre;
    private String nomSemestre;
    

    public SemestreEtudiantEtuDTO1(String etu, String nomEtudiant, Long idSemestre, String nomSemestre) {
        this.etu = etu;
        this.nomEtudiant = nomEtudiant;
        this.idSemestre = idSemestre;
        this.nomSemestre = nomSemestre;
    }

    // Getters and setters

    public String getEtu() {
        return etu;
    }

    public void setEtu(String etu) {
        this.etu = etu;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public Long getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Long idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }
}
