/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Service;

import com.example.Preval4.Model.Configuration_note;
import com.example.Preval4.Model.Temp.ConfigTemp;
import com.example.Preval4.Model.Temp.NoteTemp;
import com.example.Preval4.Repository.ConfigurationNoteRepository;
import com.example.Preval4.Repository.NoteTempRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author najai
 */

@Service
public class ImportService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ConfigurationNoteRepository configurationNoteRepository;
    @Autowired
    private NoteTempRepository noteTempRepository;
    
    @Transactional
    public void importNotesFromCsv( List<NoteTemp> notetemp) {
        noteTempRepository.saveAll(notetemp);
        jdbcTemplate.execute("CALL partageDonnecsv()");
    }
    
    @Transactional
    public void importConfigFromCsv(List<Configuration_note> configuration_note) {
        configurationNoteRepository.saveAll(configuration_note);
    }
}
