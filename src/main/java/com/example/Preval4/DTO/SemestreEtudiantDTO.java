/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.DTO;

/**
 *
 * @author najai
 */
public class SemestreEtudiantDTO { 
    private String etu;
    private String nomEtudiant;
    private Long idSemestre;
    private String nomSemestre;
    private Long rang;
    private Long rang_global;

    public SemestreEtudiantDTO(String etu, String nomEtudiant, Long idSemestre, String nomSemestre, Long rang, Long rang_global) {
        this.etu = etu;
        this.nomEtudiant = nomEtudiant;
        this.idSemestre = idSemestre;
        this.nomSemestre = nomSemestre;
        this.rang = rang;
        this.rang_global = rang_global;
    }

    public Long getRang_global() {
        return rang_global;
    }

    public void setRang_global(Long rang_global) {
        this.rang_global = rang_global;
    }


    

    public Long getRang() {
        return rang;
    }

    public void setRang(Long rang) {
        this.rang = rang;
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
