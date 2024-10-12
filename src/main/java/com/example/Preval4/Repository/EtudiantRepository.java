/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Preval4.Repository;

import com.example.Preval4.Model.Etudiant;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author najai
 */
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findAll();

}
