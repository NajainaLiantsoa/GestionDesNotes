/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Preval4.Repository;

import com.example.Preval4.Model.Configuration_note;
import com.example.Preval4.Model.Temp.ConfigTemp;
import com.example.Preval4.Model.Temp.NoteTemp;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author najai
 */
public interface ConfigurationNoteRepository extends JpaRepository<Configuration_note, Long> {
}
