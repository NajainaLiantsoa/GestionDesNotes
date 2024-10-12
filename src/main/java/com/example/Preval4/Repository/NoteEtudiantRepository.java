/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Preval4.Repository;

import com.example.Preval4.Model.NoteEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author najai
 */
@Repository
public interface NoteEtudiantRepository extends JpaRepository<NoteEtudiant, Integer> {
}

