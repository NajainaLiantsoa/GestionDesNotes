/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Controller;

import com.example.Preval4.DTO.MatiereAjourneeDTO;
import com.example.Preval4.DTO.MoyenneNoteDTO;
import com.example.Preval4.DTO.MoyenneNoteEtuDTO;
import com.example.Preval4.DTO.ReleveNoteDTO;
import com.example.Preval4.DTO.SemestreEtudiantDTO;
import com.example.Preval4.DTO.SemestreEtudiantEtuDTO1;
import com.example.Preval4.Model.Etudiant;
import com.example.Preval4.Service.AdminService;
import com.example.Preval4.Service.EtudiantService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author najai
 */

@Controller
@RequestMapping("etudiant")
public class EtudiantController {
    
    
    @Autowired
    private EtudiantService etudiantService;
    
    @Autowired
    AdminService adminService;
    
    @PostMapping("/save_etu")
    public String saveNumber(String num_etu, HttpSession session) {
        session.setAttribute("session_etu", num_etu);
        //System.out.println("numero "+phoneNumber+" ajouté dans session avec succes");
        return "redirect:/etudiant/SemestreETU";
    }
    
    @GetMapping("/test")
    public String login4() {
        return "newhtml";
    }
    
    @GetMapping("/list_bien_propriaitaire")
    public String listBien(Model model, HttpSession session) {
        String num_etu = (String) session.getAttribute("session_etu");
        if (num_etu == null) {
            return "/login_etudiant";
        }
        return "newhtml";
    }
    
        @GetMapping("/SemestreETU")
        public String getSemestreSurEtudiant(Model model, HttpSession session){
        String num_etu = (String) session.getAttribute("session_etu");
        if (num_etu == null) {
            return "/login_etudiant";
        }
        List<SemestreEtudiantEtuDTO1> semestres = etudiantService.SemestreEtudiant(num_etu);
        model.addAttribute("num_etu", num_etu);       
        model.addAttribute("semestres", semestres);
        
        List<MoyenneNoteDTO> notesem = etudiantService.MoyenneParSem(num_etu); 
        model.addAttribute("notesem", notesem);

        return "etudiant/SemestreSurEtudiant";
        
        }
        
        @GetMapping("/releve-notes")
        public String getReleveNotes(Model model, @RequestParam("semestre") Long semestre,HttpSession session){
            String num_etu = (String) session.getAttribute("session_etu");
                if (num_etu == null) {
            return "/login_etudiant";
        }
        List<ReleveNoteDTO> releveNotes = etudiantService.getReleveNotes(num_etu, semestre);
        model.addAttribute("releveNotes", releveNotes);
        List<MoyenneNoteDTO> moyenne = etudiantService.getMoyenne(num_etu, semestre);
        model.addAttribute("moyenne", moyenne);
        return "etudiant/releve-notes";
        
        }
        
         @GetMapping("/MoyenneEtudiant")
        public String getMoyenneEtudiant(Model model, @RequestParam("semestre") Long semestre,HttpSession session){
            String num_etu = (String) session.getAttribute("session_etu");
                if (num_etu == null) {
            return "/login_etudiant";
        }
        List<MoyenneNoteDTO> moyenne = etudiantService.getMoyenne(num_etu, semestre);
        model.addAttribute("moyenne", moyenne);
        return "etudiant/releve-notes_1";
        
        }
        
       @GetMapping("/MatiereAj")
public String getListMatiereAj(Model model, HttpSession session) {
    String num_etu = (String) session.getAttribute("session_etu");
    if (num_etu == null) {
        return "/login_etudiant";
    }
    List<MatiereAjourneeDTO> etu = etudiantService.getMatiereAj(num_etu);

    // Calculer le montant total du rattrapage
    long montantTotalRattrapage = etu.stream()
        .mapToLong(MatiereAjourneeDTO::getMontant_rattrapage)
        .sum();

    model.addAttribute("etu", etu);
    model.addAttribute("montantTotalRattrapage", montantTotalRattrapage);

    return "etudiant/matiereAj";
}



    
    
    

    
}
