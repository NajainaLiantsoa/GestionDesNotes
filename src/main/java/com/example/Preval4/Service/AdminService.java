/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Preval4.Service;


import com.example.Preval4.DTO.EtudiantPromotionDTO;
import com.example.Preval4.DTO.List_Matiere_Cat_MoyenneDTO;
import com.example.Preval4.DTO.MatiereAjourneeDTO;
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
import com.example.Preval4.Model.NoteEtudiant;
import com.example.Preval4.Model.Promotion;
import com.example.Preval4.Model.Semestre;
import com.example.Preval4.Repository.ConfigurationNoteRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author najai
 */

@Service
public class AdminService {
    
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private ConfigurationNoteRepository configNoteRepository;
    
     public List<Configuration_note> getAllConfigs() {
        return configNoteRepository.findAll();
    }
   
    @Transactional
    public void save(NoteEtudiant noteEtudiant) {
        String sql = "INSERT INTO note_etudiant (date_examen, id_etudiant, id_matiere, note) " +
                     "VALUES (:idEtudiant, :idMatiere, :note) " +
                     "ON CONFLICT (id) DO UPDATE SET " +
                     "id_etudiant = EXCLUDED.id_etudiant, " +
                     "id_matiere = EXCLUDED.id_matiere, " +
                     "note = EXCLUDED.note";

        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("idEtudiant", noteEtudiant.getEtudiant().getId())
                .addValue("idMatiere", noteEtudiant.getMatiere().getId())
                .addValue("note", noteEtudiant.getNote());

        namedParameterJdbcTemplate.update(sql, parameters);
    }
    
    // Méthode pour obtenir les promotions
    public List<Promotion> getAllPromotions() {
        String sql = "SELECT * FROM promotion";

        RowMapper<Promotion> rowMapper = (rs, rowNum) -> new Promotion(
            rs.getLong("id"),
            rs.getString("nom")
        );

        return namedParameterJdbcTemplate.query(sql, rowMapper);
    }
    
    public List<EtudiantPromotionDTO> EtudiantPromotion (String promotion){
     
      
      String sql = "SELECT * FROM vue_etudiants_promotion WHERE promotion_nom = :promotion";
      Map<String, Object> params = Map.of("promotion", promotion);
      
      RowMapper <EtudiantPromotionDTO> rowMapper = (rs , rowNum ) -> new EtudiantPromotionDTO(
          rs.getLong("etudiant_id"),
          rs.getString("num_etu"),
          rs.getString("nom"),
          rs.getString("prenom"),
          rs.getDate("dtn"),
          rs.getString("promotion_nom"));
      return namedParameterJdbcTemplate.query(sql,params,rowMapper);

  }
    
   public Page<EtudiantPromotionDTO> EtudiantPromotion(String nom, String prenom, String promotion, String numEtu, Pageable pageable) {
    // Ajouter les caractères génériques pour la recherche LIKE
    String nomPattern = "%" + nom + "%";
    String prenomPattern = "%" + prenom + "%";
    String promotionPattern = "%" + promotion + "%";
    String numEtuPattern = "%" + numEtu + "%";

    // Requête SQL avec conditions de recherche pour le nom, le prénom, la promotion et le num_etu avec limite pour la pagination
    String sql = "SELECT * FROM vue_etudiants_promotion WHERE nom LIKE :nom AND prenom LIKE :prenom AND promotion_nom LIKE :promotion AND num_etu LIKE :numEtu "
               + "ORDER BY promotion_nom LIMIT :limit OFFSET :offset";

    // Calcul de l'offset (page * size)
    int offset = pageable.getPageNumber() * pageable.getPageSize();

    // Map des paramètres
    Map<String, Object> params = new HashMap<>();
    params.put("nom", nomPattern);
    params.put("prenom", prenomPattern);
    params.put("promotion", promotionPattern);
    params.put("numEtu", numEtuPattern);
    params.put("limit", pageable.getPageSize());
    params.put("offset", offset);

    // RowMapper pour convertir les résultats de la requête en objets EtudiantPromotionDTO
    RowMapper<EtudiantPromotionDTO> rowMapper = (rs, rowNum) -> new EtudiantPromotionDTO(
        rs.getLong("etudiant_id"),
        rs.getString("num_etu"),
        rs.getString("nom"),
        rs.getString("prenom"),
        rs.getDate("dtn"),
        rs.getString("promotion_nom")
    );

    // Exécution de la requête pour récupérer les résultats paginés
    List<EtudiantPromotionDTO> etudiants = namedParameterJdbcTemplate.query(sql, params, rowMapper);

    // Requête pour obtenir le nombre total d'étudiants correspondant au filtre
    String countSql = "SELECT COUNT(*) FROM vue_etudiants_promotion WHERE nom LIKE :nom AND prenom LIKE :prenom AND promotion_nom LIKE :promotion AND num_etu LIKE :numEtu";
    int total = namedParameterJdbcTemplate.queryForObject(countSql, params, Integer.class);

    // Retourner un objet Page contenant les résultats paginés
    return new PageImpl<>(etudiants, pageable, total);
}



public Page<EtudiantPromotionDTO> getAllEtudiants(Pageable pageable) {
    // Requête SQL pour récupérer tous les étudiants avec pagination
    String sql = "SELECT * FROM vue_etudiants_promotion ORDER BY promotion_nom LIMIT :limit OFFSET :offset";

    // Calcul de l'offset (page * size)
    int offset = pageable.getPageNumber() * pageable.getPageSize();

    // Map des paramètres
    Map<String, Object> params = new HashMap<>();
    params.put("limit", pageable.getPageSize());
    params.put("offset", offset);

    // RowMapper pour convertir les résultats en objets EtudiantPromotionDTO
    RowMapper<EtudiantPromotionDTO> rowMapper = (rs, rowNum) -> new EtudiantPromotionDTO(
        rs.getLong("etudiant_id"),
        rs.getString("num_etu"),
        rs.getString("nom"),
        rs.getString("prenom"),
        rs.getDate("dtn"),
        rs.getString("promotion_nom")
    );

    // Exécution de la requête pour récupérer les résultats paginés
    List<EtudiantPromotionDTO> etudiants = namedParameterJdbcTemplate.query(sql, params, rowMapper);

    // Requête pour obtenir le nombre total d'étudiants
    String countSql = "SELECT COUNT(*) FROM vue_etudiants_promotion";
    int total = namedParameterJdbcTemplate.queryForObject(countSql, params, Integer.class);

    // Retourner un objet Page contenant les résultats paginés
    return new PageImpl<>(etudiants, pageable, total);
}

    
    public List <SemestreEtudiantDTO> SemestreEtudiant (String etu){
     
        String sql = "SELECT \n" +
                "    etudiant_id,\n" +
                "    ETU,\n" +
                "    etudiant_nom,\n" +
                "    etudiant_prenom,\n" +
                "    semestre_id,\n" +
                "    semestre_nom,\n" +
                "    moyenne_generale,\n" +
                "    total_credit_obtenu,\n" +
                "    resultat,\n" +
                "    mention,\n" +
                "    rang,\n" +
                "    DENSE_RANK() OVER (ORDER BY ROUND(moyenne_generale,2) DESC) AS rang_global\n" +
                "FROM \n" +
                "    resultat_etudiant_par_semestre_Dense_Rank_FIN_3\n" +
                "WHERE \n" +
                "    ETU = :etu\n" +
                "ORDER BY \n" +
                "    moyenne_generale DESC;";
              Map<String, Object> params = Map.of("etu", etu);
              
        RowMapper <SemestreEtudiantDTO> rowMapper = (rs , rowNum ) -> new SemestreEtudiantDTO(
                rs.getString("etu"),
        rs.getString("etudiant_nom"),
        rs.getLong("semestre_id"),
        rs.getString("semestre_nom"),
        rs.getLong("rang"),
        rs.getLong("rang_global")


        );   
        
              return namedParameterJdbcTemplate.query(sql,params,rowMapper);      
    }
    
    
    
     public List <MoyenneNoteEtuDTO> MoyenneParSem (String etu){
     
        String sql = "SELECT \n" +
"    etudiant_id,\n" +
"    ETU,\n" +
"    etudiant_nom,\n" +
"    etudiant_prenom,\n" +
"    semestre_id,\n" +
"    semestre_nom,\n" +
"    moyenne_generale,\n" +
"    total_credit_obtenu,\n" +
"    resultat,\n" +
"    mention,\n" +
"    rang,\n" +
"    DENSE_RANK() OVER (ORDER BY ROUND(moyenne_generale,2) DESC) AS rang_global\n" +
"FROM \n" +
"    resultat_par_promotion\n" +
"WHERE \n" +
"    ETU = :etu\n" +
"ORDER BY \n" +
"    ROUND(moyenne_generale,2) DESC;" ;
              Map<String, Object> params = Map.of("etu", etu);
              
        RowMapper <MoyenneNoteEtuDTO> rowMapper = (rs , rowNum ) -> new MoyenneNoteEtuDTO(
                        rs.getString("semestre_nom"),

                rs.getString("etu"),
            rs.getString("resultat"),
            rs.getBigDecimal("total_credit_obtenu"),
            rs.getBigDecimal("moyenne_generale"),
            rs.getString("mention"),
            rs.getLong("rang"),
                            rs.getLong("rang_global")



            
        );  
              return namedParameterJdbcTemplate.query(sql,params,rowMapper);      
    }
     
    public List<MoyenneAnneeDTO> MoyenneAnnee(Long etudiant_id) {
    String sql = "SELECT * FROM resultat_annuel WHERE etudiant_id = :etudiant_id";
    Map<String, Object> params = Map.of("etudiant_id", etudiant_id);
    
    RowMapper<MoyenneAnneeDTO> rowMapper = (rs, rowNum) -> new MoyenneAnneeDTO(
        rs.getLong("etudiant_id"),
        rs.getString("etudiant_nom"),
        rs.getString("etudiant_prenom"),
        rs.getLong("annee"),
        rs.getBigDecimal("moyenne_generale_annuelle")
    );

    return namedParameterJdbcTemplate.query(sql, params, rowMapper);
}
    
    
    public List<SemestreAnneeDTO> SemmestreAnnee(Long etudiant_id, Long annee) {
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
    
    public List<List_Matiere_Cat_MoyenneDTO> getList_Mat_Par_Categorie(String etu, Long semestre) {
        String sql = "SELECT * FROM affichage_notes_completes WHERE etu = :etu and semestre_id = :semestre;";
        Map<String, Object> params = Map.of("etu", etu, "semestre", semestre);

        RowMapper<List_Matiere_Cat_MoyenneDTO> rowMapper = (rs, rowNum) -> new List_Matiere_Cat_MoyenneDTO(
            rs.getLong("etudiant_id"),
            rs.getString("etu"),
            rs.getString("etudiant_nom"),
            rs.getString("etudiant_prenom"),
            rs.getLong("semestre_id"),
            rs.getString("semestre_nom"),
            rs.getString("ue"),
            rs.getString("intitule"),
            rs.getBigDecimal("note"),
            rs.getBigDecimal("credits"),
            rs.getString("categorie")
            
        );
                      return namedParameterJdbcTemplate.query(sql,params,rowMapper); 
    }
    
    public List<MoyenneParCategorieDTO> getMoyenne_Mat_Par_Categorie(String etu, Long semestre) {
        String sql = "SELECT * FROM moyenne_par_categorie WHERE etu = :etu and semestre_id = :semestre;";
        Map<String, Object> params = Map.of("etu", etu, "semestre", semestre);

        RowMapper<MoyenneParCategorieDTO> rowMapper = (rs, rowNum) -> new MoyenneParCategorieDTO(
    rs.getLong("etudiant_id"),          // Long etudiantId
    rs.getString("etu"),                // String etu
    rs.getString("etudiant_nom"),       // String etudiantNom
    rs.getString("etudiant_prenom"),    // String etudiantPrenom
    rs.getLong("semestre_id"),          // Long semestreId
    rs.getString("semestre_nom"),       // String semestreNom
    rs.getString("categorie"),          // String categorie
    rs.getInt("nombre_matieres"),       // Integer nombreMatieres
    rs.getBigDecimal("moyenne_ponderee")// BigDecimal moyennePonderee
);

                      return namedParameterJdbcTemplate.query(sql,params,rowMapper); 
    }
    


    
    public List<ReleveNoteSemDTO> getReleveAnnee(Long etudiant_id, Long annee) {
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
    
    
    
    
     public Map<String, Integer> getStudentStatistics() {
        String sql = "SELECT * FROM statistiques_etudiants";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Map<String, Integer> stats = new HashMap<>();
            stats.put("nombre_total_etudiants", rs.getInt("nombre_total_etudiants"));
            stats.put("nombre_etudiants_admis", rs.getInt("nombre_etudiants_admis"));
            stats.put("nombre_etudiants_ajournes", rs.getInt("nombre_etudiants_ajournes"));
            return stats;
        });
    }
     
    
     public List<Semestre> getAllSemestre() {
        String sql = "SELECT * FROM semestre";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new Semestre(
                rs.getLong("id"),
                rs.getString("nom")
            )
        );
    }
   
  public List<RangEtudiantDTO> getResultatsBySemestreId(Long semestreId) {
        String sql = "SELECT * FROM resultat_etudiant_par_semestre_Dense_Rank_All_Prom WHERE semestre_id = :id";
                Map<String, Object> params = Map.of("id", semestreId);


        RowMapper<RangEtudiantDTO> rowMapper = (rs, rowNum) -> new RangEtudiantDTO(
                rs.getString("etu"),
                rs.getString("etudiant_nom"),
                rs.getString("etudiant_prenom"),
                rs.getLong("semestre_id"),
                rs.getString("semestre_nom"),
                rs.getBigDecimal("moyenne_generale"),
                rs.getInt("total_credit_obtenu"),
                rs.getString("resultat"),
                rs.getString("mention"),
                rs.getInt("rang")
           
        );
        return namedParameterJdbcTemplate.query(sql,params,rowMapper);  
    }
     
    
    
            
}
