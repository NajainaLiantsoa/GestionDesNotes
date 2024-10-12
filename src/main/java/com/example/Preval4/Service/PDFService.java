package com.example.Preval4.Service;

import com.example.Preval4.DTO.ReleveNoteSemDTO;
import com.example.Preval4.DTO.SemestreAnneeDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PDFService {

    public void export(HttpServletResponse response, List<SemestreAnneeDTO> semestreResults, List<ReleveNoteSemDTO> summaryResults) throws DocumentException, IOException {
        if (semestreResults.isEmpty() && summaryResults.isEmpty()) {
            throw new IllegalArgumentException("Les résultats ne peuvent pas être vides.");
        }

        // Extraire les informations de l'étudiant du premier élément de la liste
        SemestreAnneeDTO firstResult = semestreResults.get(0);
        String nomEtudiant = firstResult.getEtudiant_nom();
        String prenomEtudiant = firstResult.getEtudiant_prenom();
        int annee = firstResult.getAnnee();

        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());

        // Définir le nom du fichier dans l'en-tête de réponse
        String fileName = String.format("%s_%s_L%d.pdf", nomEtudiant, prenomEtudiant, annee);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        document.open();

        // Définir les polices
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.DARK_GRAY);
        Font tableHeaderFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        Font tableBodyFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
        Font summaryFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.DARK_GRAY);

        // Titre du document
        Paragraph title = new Paragraph("Résultats des Semestres", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(10);
        document.add(title);

        // Regrouper les résultats par semestre
        String currentSemestre = "";
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(5);
        table.setSpacingAfter(5);

        addTableHeader(table, tableHeaderFont);

        for (SemestreAnneeDTO result : semestreResults) {
            if (!result.getNom_semestre().equals(currentSemestre)) {
                if (!currentSemestre.isEmpty()) {
                    // Ajouter le tableau précédent avant de commencer un nouveau semestre
                    document.add(table);

                    // Ajouter le résumé des résultats pour le semestre précédent
                    addSummaryForSemestre(document, currentSemestre, summaryResults, summaryFont);

                    // Réinitialiser la table pour le nouveau semestre
                    table = new PdfPTable(5);
                    table.setWidthPercentage(100);
                    table.setSpacingBefore(5);
                    table.setSpacingAfter(5);
                    addTableHeader(table, tableHeaderFont);
                }
                currentSemestre = result.getNom_semestre();
                Paragraph semestreTitle = new Paragraph(currentSemestre, titleFont);
                semestreTitle.setAlignment(Element.ALIGN_CENTER);
                semestreTitle.setSpacingBefore(5);
                semestreTitle.setSpacingAfter(5);
                document.add(semestreTitle);
            }
            addRow(table, result, tableBodyFont);
        }

        // Ajouter le dernier tableau
        if (!semestreResults.isEmpty()) {
            document.add(table);

            // Ajouter le résumé des résultats pour le dernier semestre
            addSummaryForSemestre(document, currentSemestre, summaryResults, summaryFont);
        }

        document.close();
    }

    private void addTableHeader(PdfPTable table, Font font) {
        Stream.of("UE", "Intitulé", "Crédit", "Note", "Résultat")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell(new Phrase(columnTitle, font));
                    header.setBackgroundColor(BaseColor.DARK_GRAY);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setPadding(5);
                    table.addCell(header);
                });
    }

    private void addRow(PdfPTable table, SemestreAnneeDTO result, Font font) {
        table.addCell(new Phrase(result.getUe(), font));
        table.addCell(new Phrase(result.getIntitule(), font));
        table.addCell(new Phrase(String.valueOf(result.getCredit()), font));
        table.addCell(new Phrase(String.valueOf(result.getNote()), font));
        table.addCell(new Phrase(result.getResultat(), font));
    }

    private void addSummaryForSemestre(Document document, String semestre, List<ReleveNoteSemDTO> summaryResults, Font font) throws DocumentException {
        // Trouver le résumé pour le semestre en cours
        ReleveNoteSemDTO summary = summaryResults.stream()
                .filter(s -> s.getSemestre_nom().equals(semestre))
                .findFirst()
                .orElse(null);

        if (summary != null) {
            // Ajouter le résumé des résultats pour le semestre
            document.add(new Paragraph(" ", font)); // Ajouter un espace avant le résumé

            Paragraph summaryTitle = new Paragraph("Résumé des Résultats", font);
            summaryTitle.setAlignment(Element.ALIGN_CENTER);
            summaryTitle.setSpacingBefore(10);
            summaryTitle.setSpacingAfter(5);
            document.add(summaryTitle);

            Paragraph credits = new Paragraph("Crédits Obtenus: " + summary.getTotal_credit_obtenu(), font);
            credits.setSpacingBefore(5);
            document.add(credits);

            Paragraph moyenne = new Paragraph("Moyenne Générale: " + summary.getMoyenne_generale(), font);
            moyenne.setSpacingBefore(5);
            document.add(moyenne);

            Paragraph mention = new Paragraph("Mention: " + summary.getMention(), font);
            mention.setSpacingBefore(5);
            document.add(mention);
        }
    }
}
