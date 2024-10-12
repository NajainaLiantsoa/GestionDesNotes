/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Controller;

import com.example.Preval4.DTO.SemestreAnneeDTO;
import com.example.Preval4.Service.ExportService;
import com.example.Preval4.Service.PDFService;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("export")
public class ExportController {

    @Autowired
    private ExportService exportService;

    @Autowired
    private PDFService pdfService;

    /*@GetMapping("/export/pdf")
    @ResponseBody
    public void exportToPDF(@RequestParam("annee") int annee,
                            @RequestParam("etudiantId") int etudiantId,
                            HttpServletResponse response) throws IOException, DocumentException {

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Resultats_Semestres.pdf");

        // Récupérer les données depuis la vue SQL
        List<SemestreAnneeDTO> results = exportService.SemmestreAnnee(etudiantId, annee);

        // Générer le PDF
        pdfService.export(response, results);
    }*/
}

