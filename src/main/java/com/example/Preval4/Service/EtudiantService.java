/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Service;

import com.example.Preval4.DTO.MatiereAjourneeDTO;
import com.example.Preval4.DTO.MoyenneNoteDTO;
import com.example.Preval4.DTO.MoyenneNoteEtuDTO;
import com.example.Preval4.DTO.ReleveNoteDTO;
import com.example.Preval4.DTO.SemestreEtudiantDTO;
import com.example.Preval4.DTO.SemestreEtudiantEtuDTO1;
import com.example.Preval4.Model.Etudiant;
import com.example.Preval4.Repository.EtudiantRepository;
import com.example.Preval4.Repository.EtudiantsRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author najai
 */
@Service
public class EtudiantService {
    
     
     
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
     @Autowired
    private EtudiantRepository etudiantRepository;
     
     @Autowired
      private EtudiantsRepository etudiantsRepository;
     
        
    
    public List <SemestreEtudiantEtuDTO1> SemestreEtudiant (String etu){
     
        String sql = "SELECT * FROM  Semestre_etudiant WHERE ETU = :etu";
              Map<String, Object> params = Map.of("etu", etu);
              
        RowMapper <SemestreEtudiantEtuDTO1> rowMapper = (rs , rowNum ) -> new SemestreEtudiantEtuDTO1(
                rs.getString("ETU"),
        rs.getString("nom_etudiant"),
        rs.getLong("id_semestre"),
        rs.getString("nom_semestre")

        );  
        
              return namedParameterJdbcTemplate.query(sql,params,rowMapper);      
    }
    
    public List<ReleveNoteDTO> getReleveNotes(String etu, Long semestre) {
        String sql = "SELECT * FROM releve_note_par_semestre_3 WHERE ETU = :etu AND semestre_id = :semestre";
        Map<String, Object> params = Map.of("etu", etu, "semestre", semestre);

       RowMapper<ReleveNoteDTO> rowMapper = (rs, rowNum) -> new ReleveNoteDTO(
            rs.getLong("etudiant_id"),
            rs.getString("ETU"),
            rs.getString("etudiant_nom"),
            rs.getString("etudiant_prenom"),
            rs.getLong("semestre_id"),
            rs.getString("semestre_nom"),
            rs.getString("intitule"),
            rs.getString("ue"),
            rs.getBigDecimal("credit_obtenu"),
            rs.getBigDecimal("note"),
            rs.getString("resultat")
        );
                      return namedParameterJdbcTemplate.query(sql,params,rowMapper);
    }
    
    public List<MoyenneNoteDTO> getMoyenne(String etu, Long semestre) {
        String sql = "SELECT * FROM resultat_etudiant_par_semestre WHERE ETU = :etu AND semestre_id = :semestre";
        Map<String, Object> params = Map.of("etu", etu, "semestre", semestre);

        RowMapper<MoyenneNoteDTO> rowMapper = (rs, rowNum) -> new MoyenneNoteDTO(
            rs.getString("ETU"),
            rs.getString("resultat"),
            rs.getBigDecimal("total_credit_obtenu"),
            rs.getBigDecimal("moyenne_generale"),
            rs.getString("mention")


            
        );
                      return namedParameterJdbcTemplate.query(sql,params,rowMapper);
    }
    
    public Page<Etudiant> listEtudiants(int page, int size) {
        return etudiantRepository.findAll(PageRequest.of(page, size));
    }
    
    
     public List<MatiereAjourneeDTO> getMatiereAj(String etu) {
        String sql = "SELECT * FROM matieres_ajournees_par_semestre_non_calculer_AJ_Iny WHERE ETU = :etu";
        Map<String, Object> params = Map.of("etu", etu);

        RowMapper<MatiereAjourneeDTO> rowMapper = (rs, rowNum) -> new MatiereAjourneeDTO(
             rs.getString("semestre_nom"),
            rs.getString("ue"),
            rs.getString("matiere"),
            rs.getLong("note"),
            rs.getLong("montant_rattrapage")

        );
         return namedParameterJdbcTemplate.query(sql,params,rowMapper);      

    }
     
     public List <MoyenneNoteDTO> MoyenneParSem (String etu){
     
        String sql = "SELECT * FROM resultat_etudiant_par_semestre_No_Round WHERE ETU = :etu";
              Map<String, Object> params = Map.of("etu", etu);
              
        RowMapper <MoyenneNoteDTO> rowMapper = (rs , rowNum ) -> new MoyenneNoteDTO(
        rs.getString("etu"),
            rs.getString("resultat"),
            rs.getBigDecimal("total_credit_obtenu"),
            rs.getBigDecimal("moyenne_generale"),
            rs.getString("mention")

            
        );  
              return namedParameterJdbcTemplate.query(sql,params,rowMapper);      
    }
     
     public List<Etudiant> findByPromotionId(Long promotionId) {
        return etudiantsRepository.findByPromotionId(promotionId);
    }
    
}


