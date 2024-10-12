/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Model.Temp;

import com.example.Preval4.Model.Configuration_note;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.time.LocalDate;
import org.springframework.jdbc.core.JdbcTemplate;



public class CsvUtility {
    
     private JdbcTemplate jdbcTemplate;

    public CsvUtility(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static String TYPE = "text/csv";

    public static boolean hasCsvFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    

     public static List<NoteTemp> parseNoteTempFromCsv(MultipartFile file) {
        List<NoteTemp> noteTempList = new ArrayList<>();
        int lineNumber = 0;
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            csvReader.readNext(); // Ignore header line

            String[] fields;
            while ((fields = csvReader.readNext()) != null) {
                lineNumber++;
                try{
                
                NoteTemp noteTemp = parseNoteTempData(fields);
                noteTempList.add(noteTemp);
                System.out.println("Line number " + lineNumber + " added successfully");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage() + " at line number " + lineNumber);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading CSV file: " + e);
        }
        return noteTempList;
    }

     public static NoteTemp parseNoteTempData(String[] fields) {
        NoteTemp noteTemp = new NoteTemp();
        noteTemp.setNumetu(fields[0].trim());
        noteTemp.setNom(fields[1].trim());
        noteTemp.setPrenom(fields[2].trim());
        noteTemp.setGenre(fields[3].trim());
        noteTemp.setDatenaissance(parseDate(fields[4].trim()));
        noteTemp.setPromotion(fields[5].trim());
        noteTemp.setCodematiere(fields[6].trim());
        noteTemp.setSemestre(fields[7].trim()); // Assume semestre is in column 8
        noteTemp.setNote(Double.parseDouble(fields[8].trim().replace(",", "."))); // Assume note is in column 9
        return noteTemp;
    }
    
    
    public static List<Configuration_note> parseConfigTempFromCsv(MultipartFile file) {
        List<Configuration_note> configTempList = new ArrayList<>();
        int lineNumber = 0;
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            csvReader.readNext(); // Ignore header line

            String[] fields;
            while ((fields = csvReader.readNext()) != null) {
                lineNumber++;
                try{
                
                Configuration_note configuration_note = parseConfigTempData(fields);
                configTempList.add(configuration_note);
                System.out.println("Line number " + lineNumber + " added successfully");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage() + " at line number " + lineNumber);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading CSV file: " + e);
        }
        return configTempList;
    }
    
     public static Configuration_note parseConfigTempData(String[] fields) {
    Configuration_note configuration_note = new Configuration_note();
    configuration_note.setCode(fields[0].trim());
    configuration_note.setConfig(fields[1].trim());
    configuration_note.setValeur(Integer.parseInt(fields[2].trim()));
    return configuration_note;
}
    
    private static java.sql.Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date parsedDate = dateFormat.parse(dateString);
            return new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }
    }
}
