/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Controller;


import com.example.Preval4.DTO.EtudiantPromotionDTO;
import com.example.Preval4.DTO.List_Matiere_Cat_MoyenneDTO;
import com.example.Preval4.DTO.MoyenneAnneeDTO;
import com.example.Preval4.DTO.MoyenneNoteDTO;
import com.example.Preval4.DTO.MoyenneNoteEtuDTO;
import com.example.Preval4.DTO.MoyenneParCategorieDTO;
import com.example.Preval4.DTO.RangEtudiantDTO;
import com.example.Preval4.DTO.ReleveNoteDTO;
import com.example.Preval4.DTO.ReleveNoteSemDTO;
import com.example.Preval4.DTO.SemestreAnneeDTO;
import com.example.Preval4.DTO.SemestreEtudiantDTO;
import com.example.Preval4.Model.Configuration_note;
import com.example.Preval4.Model.Etudiant;
import com.example.Preval4.Model.Matiere;
import com.example.Preval4.Model.NoteEtudiant;
import com.example.Preval4.Model.Promotion;
import com.example.Preval4.Model.Semestre;
import com.example.Preval4.Model.Temp.ConfigTemp;
import java.math.BigDecimal;

import com.example.Preval4.Model.Temp.CsvUtility;
import com.example.Preval4.Model.Temp.NoteTemp;
import com.example.Preval4.Repository.EtudiantRepository;
import com.example.Preval4.Repository.EtudiantsRepository;
import com.example.Preval4.Repository.MatiereRepository;
import com.example.Preval4.Repository.PromotionRepository;
import com.example.Preval4.Service.AdminService;
import com.example.Preval4.Service.ConfigurationNoteService;
import com.example.Preval4.Service.EtudiantService;
import com.example.Preval4.Service.ExportService;
import com.example.Preval4.Service.ImportService;
import com.example.Preval4.Service.NoteEtudiantService;
import com.example.Preval4.Service.PDFService;
import com.itextpdf.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author najai
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private EtudiantRepository etudiantRepository;
    
     @Autowired
    private EtudiantsRepository etudiantsRepository;

    @Autowired
    private MatiereRepository matiereRepository;
    
    @Autowired
    private NoteEtudiantService noteEtudiantService;
    
    @Autowired
    private ImportService importService;
    
    @Autowired
    private ExportService exportService;

    @Autowired
    private PDFService pdfService;
    
    @Autowired
    private EtudiantService etudiantService;
    
    
    
      @Autowired
    private PromotionRepository promotionRepository;
    
      

     @Autowired
    private ConfigurationNoteService configurationNoteService;
    
    private final JdbcTemplate jdbcTemplate;
    
    public AdminController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @GetMapping("/loginform")
    public String showForm() {
        return "Saisie_Note_Etudiant";
    }
    
     @GetMapping("/saisirNoteForm")
    public String showSaisirNoteForm(Model model) {
        model.addAttribute("etudiants", etudiantRepository.findAll());
        model.addAttribute("matieres", matiereRepository.findAll());
        model.addAttribute("noteEtudiant", new NoteEtudiant());
        return "Saisie_Note_Etudiant";
    }
    
    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute NoteEtudiant noteEtudiant) {
        noteEtudiantService.save(noteEtudiant);
        return "redirect:/admin/saisirNoteForm" ;
    }
    
    @GetMapping("/etudiants")
    public String getEtudiantsByPromotion(@RequestParam(required = false) String promotion, Model model) {
        List<Promotion> promotions = adminService.getAllPromotions();
        model.addAttribute("promotions", promotions);

        if (promotion != null && !promotion.isEmpty()) {
            List<EtudiantPromotionDTO> etudiants = adminService.EtudiantPromotion(promotion);
            model.addAttribute("etudiants", etudiants);
        }
        
        return "Etudiant_promotionFiltre_2";
    }
    
   
    
   @GetMapping("/etudiantsFiltre")
public String getEtudiantsByPromotion(
        @RequestParam(required = false) String nom,
        @RequestParam(required = false) String prenom,
        @RequestParam(required = false) String promotion,
        @RequestParam(required = false) String numEtu,          // Nouveau paramètre pour num_etu
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        Model model) {

    Pageable pageable = PageRequest.of(page, size);

    Page<EtudiantPromotionDTO> etudiantsPage;

    // Vérifier si l'un des filtres est présent
    if ((nom != null && !nom.isEmpty()) || 
        (prenom != null && !prenom.isEmpty()) ||
        (promotion != null && !promotion.isEmpty()) ||
        (numEtu != null && !numEtu.isEmpty())) {

        // Appeler le service avec les filtres appropriés
        etudiantsPage = adminService.EtudiantPromotion(nom, prenom, promotion, numEtu, pageable);
    } else {
        etudiantsPage = adminService.getAllEtudiants(pageable);
    }

    List<Promotion> promotions = adminService.getAllPromotions();
    model.addAttribute("promotions", promotions);
    model.addAttribute("etudiantsPage", etudiantsPage);
    return "Etudiant_promotionFiltre";
}




    
   
    
    @GetMapping("/semestre/details")
    public String getSemestresByEtudiant(@RequestParam("numEtu") String numEtu, Model model) {
        
    List<SemestreEtudiantDTO> semestres = adminService.SemestreEtudiant(numEtu);
    model.addAttribute("semestres", semestres);
    
    List<MoyenneNoteEtuDTO> notesem = adminService.MoyenneParSem(numEtu); 
    model.addAttribute("notesem", notesem);
    return "Moyenne_Par_Semestre";
}
    
    @GetMapping("/semestre/list")
    public String getSemestresBList(@RequestParam("numEtu") String numEtu, Model model) {
        
    List<SemestreEtudiantDTO> semestres = adminService.SemestreEtudiant(numEtu);
    model.addAttribute("semestres", semestres);
    
    return "Moyenne_Par_Semestre_2";
}
        @GetMapping("/releve-notes")
    public String getReleveNotes(@RequestParam("etu") String etu,
                                 @RequestParam("semestre") Long semestre,
                                 Model model) {
        List<ReleveNoteDTO> releveNotes = adminService.getReleveNotes(etu, semestre);
        model.addAttribute("releveNotes", releveNotes);
        return "releve-notes"; 
    }
    
    
    
    @GetMapping("/NoteAnnuel")
    public String getNoteAnnuel(@RequestParam("etudiant_id") Long etudiant_id, Model model){
        
    List<MoyenneAnneeDTO> noteAnnuel = adminService.MoyenneAnnee(etudiant_id);
    model.addAttribute("noteAnnuel",noteAnnuel);
    return "noteAnnuel";
    
    }
    
    
    @PostMapping("/upload_note_config")
    public String uploadCsv(@RequestParam("file_note") 
                                MultipartFile file_note,
                                Model model) {
       try {  
            List<NoteTemp> notetemp = CsvUtility.parseNoteTempFromCsv(file_note);
            importService.importNotesFromCsv(notetemp);
            return "import";
        } catch (Exception e) {
            System.out.println("MISY ERREUR AN "+ e.getMessage());
            model.addAttribute("error", "Une erreur s'est produite lors de l'importation : " + e.getMessage());
            return "Import_Donnee";
        }
    }
    
     @PostMapping("/upload_config")
    public String uploadPoints(@RequestParam("file_config") MultipartFile file_config, Model model) {
        List<Configuration_note> configuration_note = CsvUtility.parseConfigTempFromCsv(file_config);
        importService.importConfigFromCsv(configuration_note);
        return "Import_Donnee";
    }
    
    
   @GetMapping("/formulaire_import")
    public String importer(Model model) {
        // Rechercher les statistiques des étudiants
        Map<String, Integer> stats = adminService.getStudentStatistics();
        model.addAttribute("nombre_total_etudiants", stats.get("nombre_total_etudiants"));
        model.addAttribute("nombre_etudiants_admis", stats.get("nombre_etudiants_admis"));
        model.addAttribute("nombre_etudiants_ajournes", stats.get("nombre_etudiants_ajournes"));
        return "Import_Donnee";
    }
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        Map<String, Integer> stats = adminService.getStudentStatistics();
        model.addAttribute("nombre_total_etudiants", stats.get("nombre_total_etudiants"));
        model.addAttribute("nombre_etudiants_admis", stats.get("nombre_etudiants_admis"));
        model.addAttribute("nombre_etudiants_ajournes", stats.get("nombre_etudiants_ajournes"));
        return "dashboard";
    }
    
    @GetMapping("/reinitialiserBase")
    public String reinitialiserBase() {
        try {
            
            jdbcTemplate.execute("CALL reinitialiser_base()");
            return "import";
        } catch (Exception e) {
            return "Erreur lors de la réinitialisation de la base de données : " + e.getMessage();
        }
        
    }
    
    @GetMapping("/semestresParAnnee")
    public String getSemestresParAnnee(@RequestParam("etudiant_id") Long etudiantId,
                                       @RequestParam("annee") Long annee,
                                       Model model) {
        List<SemestreAnneeDTO> semestres = adminService.SemmestreAnnee( etudiantId, annee);
        model.addAttribute("semestres", semestres);
        model.addAttribute("etudiantId", etudiantId);
        model.addAttribute("annee", annee);
        
        List<ReleveNoteSemDTO> moyenne = adminService.getReleveAnnee(etudiantId, annee);
        model.addAttribute("moyenne", moyenne);
        return "semestresParAnnee";
    }
    
    
    @GetMapping("/export/pdf")
public void exportToPDF(
    @RequestParam("etudiantId") int etudiantId,
    @RequestParam("annee") int annee,
    HttpServletResponse response
) throws IOException, DocumentException {
    // Définir le type de contenu et le nom du fichier
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", "attachment; filename=Resultats_Semestres.pdf");

    // Récupérer les données depuis le service
    List<SemestreAnneeDTO> semestreResults = exportService.SemmestreAnnee(etudiantId, annee);
    List<ReleveNoteSemDTO> summaryResults = exportService.getReleveAnnee(etudiantId, annee);

    // Générer le PDF en utilisant le service PDF
    pdfService.export(response, semestreResults, summaryResults);
}

    
    
    @GetMapping("/listEtudiants")
    public String listEtudiants(Model model,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size) {
        Page<Etudiant> etudiantPage = etudiantService.listEtudiants(page, size);
        model.addAttribute("etudiants", etudiantPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", etudiantPage.getTotalPages());
        return "listEtudiants";
    }
    
      @GetMapping("/configurations")
    public String showConfigurations(Model model) {
        model.addAttribute("configurations", configurationNoteService.getAllConfigurations());
        return "configurations";
    }

    @GetMapping("/editConfiguration")
    public String editConfiguration(@RequestParam Long id, Model model) {
        Configuration_note config = configurationNoteService.getConfiguration(id).orElse(null);
        model.addAttribute("configuration", config);
        return "editConfiguration";
    }

    @PostMapping("/updateConfiguration")
    public String updateConfiguration(@RequestParam Long id, @RequestParam Integer valeur) {
        // Récupérez l'entité existante
        Configuration_note existingConfig = configurationNoteService.getConfiguration(id)
            .orElseThrow(() -> new IllegalArgumentException("Configuration not found"));

        // Mettez à jour la valeur
        existingConfig.setValeur(valeur);

        // Sauvegardez les modifications
        configurationNoteService.updateConfiguration(existingConfig);

        // Redirection vers la liste des configurations
        return "redirect:/admin/configurations";
    }
    
   @GetMapping("/semestresList")
    public String listSemestres(Model model) {
        List<Semestre> semestres = adminService.getAllSemestre();
        model.addAttribute("semestres", semestres);
        return "Resultat_Rang_Etu";
    }
    
    @GetMapping("/semestre/{id}/resultats")
    public String showResultatsBySemestre(@PathVariable("id") Long semestreId, Model model) {
        List<RangEtudiantDTO> resultats = adminService.getResultatsBySemestreId(semestreId);
        model.addAttribute("resultats", resultats);
        return "resultats";  // Le nom de votre fichier HTML pour afficher les résultats
    }
    
     // Afficher le formulaire pour insérer une note
    @GetMapping("/insertNote")
    public String showInsertNoteForm(Model model) {
        // Récupérer la liste des matières et des promotions
        List<Matiere> matieres = matiereRepository.findAll();
        List<Promotion> promotions = promotionRepository.findAll();
        
        // Ajouter les matières et promotions au modèle pour les afficher dans le formulaire
        model.addAttribute("matieres", matieres);
        model.addAttribute("promotions", promotions);
        
        return "admin/insertNoteForm"; // Nom du template Thymeleaf pour afficher le formulaire
    }

    @GetMapping("/noteProm")
    public String showNoteForm(Model model) {
        List<Matiere> matieres = matiereRepository.findAll();
        List<Promotion> promotions = promotionRepository.findAll();
        model.addAttribute("matieres", matieres);
        model.addAttribute("promotions", promotions);
        return "noteProm";
    }

    @PostMapping("/insertNote")
    public String insertNote(
            @RequestParam("matiere") Long matiereId,
            @RequestParam("promotion") Long promotionId,
            @RequestParam("note") BigDecimal note,
            RedirectAttributes redirectAttributes) {
        
        List<Etudiant> etudiants = etudiantsRepository.findByPromotionId(promotionId);
        Matiere matiere = matiereRepository.findById(matiereId).orElse(null);

        if (matiere != null) {
            for (Etudiant etudiant : etudiants) {
                NoteEtudiant noteEtudiant = new NoteEtudiant();
                noteEtudiant.setEtudiant(etudiant);
                noteEtudiant.setMatiere(matiere);
                noteEtudiant.setNote(note);
                noteEtudiantService.saveNote(noteEtudiant);
            }
            redirectAttributes.addFlashAttribute("message", "Notes insérées avec succès.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Matière non trouvée.");
        }
        
        return "redirect:/admin/noteProm";
    }
   /*@GetMapping("/notes/categorie")
public String afficherNotesParCategorie(@RequestParam("etu") String etu, 
                                        @RequestParam("semestre") Long semestre, 
                                        Model model) {
    // Récupère les notes par catégorie à partir du service
    List<List_Matiere_Cat_MoyenneDTO> notesParCategorie = adminService.getList_Mat_Par_Categorie(etu, semestre);
    model.addAttribute("notesParCategorie", notesParCategorie);

    // Récupère les moyennes par catégorie à partir du service et les convertit en Map
    Map<String, BigDecimal> moyennesParCategorieMap = adminService.getMoyenne_Mat_Par_Categorie(etu, semestre)
        .stream()
        .collect(Collectors.toMap(MoyenneParCategorieDTO::getCategorie, MoyenneParCategorieDTO::getMoyennePonderee));
    model.addAttribute("moyennesParCategorieMap", moyennesParCategorieMap);

    return "NoteParCateg";
}*/
    
    @GetMapping("/notes/categorie")
public String afficherNotesParCategorie(@RequestParam("etu") String etu, 
                                        @RequestParam("semestre") Long semestre, 
                                        Model model) {
    // Récupère les notes par catégorie à partir du service
    
    

    List<List_Matiere_Cat_MoyenneDTO> notesParCategorie = adminService.getList_Mat_Par_Categorie(etu, semestre);
    model.addAttribute("notesParCategorie", notesParCategorie);

    // Récupère les moyennes par catégorie à partir du service et les convertit en Map
    List<MoyenneParCategorieDTO> moyennesParCategorieMap = adminService.getMoyenne_Mat_Par_Categorie(etu, semestre);
    model.addAttribute("moyennesParCategorieMap", moyennesParCategorieMap);

    return "NoteParCateg";
}



}
   
    

