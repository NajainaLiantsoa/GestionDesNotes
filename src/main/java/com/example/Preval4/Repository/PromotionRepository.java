/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Preval4.Repository;

import com.example.Preval4.Model.Promotion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author najai
 */
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
    List<Promotion> findAll();
}