/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Service;

/**
 *
 * @author najai
 */
import com.example.Preval4.Model.Configuration_note;
import com.example.Preval4.Repository.ConfigurationNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationNoteService {

    @Autowired
    private ConfigurationNoteRepository repository;

    public List<Configuration_note> getAllConfigurations() {
        return repository.findAll();
    }

    public Optional<Configuration_note> getConfiguration(Long id) {
        return repository.findById(id);
    }

    public void updateConfiguration(Configuration_note config) {
        repository.save(config);
    }
}
