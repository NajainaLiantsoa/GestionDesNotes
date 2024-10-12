/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Service;

import com.example.Preval4.Model.Etudiant;
import com.example.Preval4.Model.Matiere;
import com.example.Preval4.Model.NoteEtudiant;
import com.example.Preval4.Repository.NoteEtudiantRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author najai
 */
@Service
public class NoteEtudiantService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private NoteEtudiantRepository noteEtudiantRepository;
    

    
    @Transactional
    public void saveNote(NoteEtudiant noteEtudiant) {
        noteEtudiantRepository.save(noteEtudiant);
    }
    @Autowired
    public NoteEtudiantService(NoteEtudiantRepository noteEtudiantRepository) {
        this.noteEtudiantRepository = noteEtudiantRepository;
    }
    

    public void save(NoteEtudiant noteEtudiant) {
        String sql = "INSERT INTO note_etudiant ( id_etudiant, id_matiere, note) VALUES (?, ?, ?)";
        
        jdbcTemplate.update(sql,
                noteEtudiant.getEtudiant().getId(),
                noteEtudiant.getMatiere().getId(),
                noteEtudiant.getNote());
        
    }
    
    
    
    
    

    

    @Transactional
    public void insertNoteForPromotion(List<Etudiant> etudiants, Matiere matiere, BigDecimal note) {
        for (Etudiant etudiant : etudiants) {
            NoteEtudiant noteEtudiant = new NoteEtudiant();
            noteEtudiant.setEtudiant(etudiant);
            noteEtudiant.setMatiere(matiere);
            noteEtudiant.setNote(note);
            saveNote(noteEtudiant);
        }
    }

}