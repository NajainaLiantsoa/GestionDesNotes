/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Model;

import com.example.Preval4.DTO.List_Matiere_Cat_MoyenneDTO;
import java.util.List;

/**
 *
 * @author najai
 */
public class Categorie {
    private String categorie;
    private List<List_Matiere_Cat_MoyenneDTO> matieres;

    // Constructeurs, getters et setters

    public Categorie(String categorie, List<List_Matiere_Cat_MoyenneDTO> matieres) {
        this.categorie = categorie;
        this.matieres = matieres;
    }

    public String getCategorie() {
        return categorie;
    }

    public List<List_Matiere_Cat_MoyenneDTO> getMatieres() {
        return matieres;
    }
}

