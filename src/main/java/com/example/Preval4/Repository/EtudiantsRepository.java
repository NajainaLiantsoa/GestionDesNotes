/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Preval4.Repository;

import com.example.Preval4.Model.Etudiant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author najai
 */
@Repository
public interface EtudiantsRepository extends JpaRepository<Etudiant, Long> {
    
    // Méthode pour récupérer tous les étudiants d'une promotion spécifique
    List<Etudiant> findByPromotionId(Long promotionId);
}
