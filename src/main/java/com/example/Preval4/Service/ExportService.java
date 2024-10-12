/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Service;

import com.example.Preval4.DTO.ReleveNoteSemDTO;
import com.example.Preval4.DTO.SemestreAnneeDTO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author najai
 */

@Service
public class ExportService {
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    public List<SemestreAnneeDTO> SemmestreAnnee(int etudiant_id, int annee) {
    String sql = "SELECT * FROM releve_note_sem_annee_3 WHERE  etudiant_id = :etudiant_id AND annee = :annee ";
    Map<String, Object> params = Map.of("etudiant_id", etudiant_id ,"annee" ,annee );

    RowMapper<SemestreAnneeDTO> rowMapper = (rs, rowNum) -> new SemestreAnneeDTO(
            
            
        rs.getString("etudiant_nom"),        
        rs.getString("etudiant_prenom"),
            
        rs.getString("semestre_nom"),
         rs.getString("ue"),
        rs.getString("intitule"),
         rs.getLong("credit_obtenu"),
            rs.getBigDecimal("note"),
        rs.getString("resultat"),
        rs.getInt("annee")

    );

    return namedParameterJdbcTemplate.query(sql, params, rowMapper);
}
    
    public List<ReleveNoteSemDTO> getReleveAnnee(int etudiant_id, int annee) {
        String sql = "SELECT * FROM semestres_avec_anneeAl WHERE etudiant_id = :etudiant_id AND annee = :annee";
        Map<String, Object> params = Map.of("etudiant_id", etudiant_id, "annee", annee);

        RowMapper<ReleveNoteSemDTO> rowMapper = (rs, rowNum) -> new ReleveNoteSemDTO(
            rs.getString("etudiant_nom"),

            rs.getString("semestre_nom"),
            rs.getBigDecimal("moyenne_generale"),
            rs.getLong("total_credit_obtenu"),
            rs.getString("mention"),
            rs.getString("resultat")

        );
         return namedParameterJdbcTemplate.query(sql,params,rowMapper);      

    }
}
