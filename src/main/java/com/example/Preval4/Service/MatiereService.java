/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Service;

import com.example.Preval4.Model.Matiere;
import com.example.Preval4.Repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author najai
 */
@Service
public class MatiereService {


    @Autowired
    private MatiereRepository matiereRepository;

    public Matiere findById(Long id) {
        return matiereRepository.findById(id).orElse(null);
    }
}
