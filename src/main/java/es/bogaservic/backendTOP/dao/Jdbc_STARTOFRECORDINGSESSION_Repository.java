/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import es.bogaservic.backendTOP.models.FallosFracasoSalidaEntrante;
import es.bogaservic.backendTOP.models.T_TOP2000_STARTOFRECORDINGSESSION;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author F.J. BOGA
 *
 */
@Repository
public class Jdbc_STARTOFRECORDINGSESSION_Repository implements T_TOP2000_STARTOFRECORDINGSESSION_Repository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*public DAO_STARTOFRECORDINGSESSION(JdbcTemplate jdbc) {
        this.jdbcTemplate = jdbc;
    }*/
    
    public List<T_TOP2000_STARTOFRECORDINGSESSION> findAll() {
        List<T_TOP2000_STARTOFRECORDINGSESSION> results = jdbcTemplate.query(
                "select * FROM T_TOP2000_STARTOFRECORDINGSESSION",
                this::mapRowToSessionFindAll);
        return results;
    }
    private T_TOP2000_STARTOFRECORDINGSESSION mapRowToSessionFindAll(ResultSet row, int rowNum) throws SQLException {
        return new T_TOP2000_STARTOFRECORDINGSESSION(
                row.getInt("nID"),
                row.getString("sMachineType"),
                row.getInt("iCenterId"),
                row.getInt("iMachineId"),
                row.getString("dDate"),
                row.getString("hTime"),
                row.getString("sFullTime"),
                row.getInt("iSessionNumber"),
                row.getString("sEvent"),
                row.getInt("iNiveauExploit"),
                row.getString("sShift"),
                row.getString("sExploitationPlan")
        );
    }    
    
    @Override
    public List<FallosFracasoSalidaEntrante> findByMaquina(int maquina) {
        String recordingBase = "SELECT T_TOP2000_STARTOFRECORDINGSESSION.iSessionNumber "
            + "FROM T_TOP2000_STARTOFRECORDINGSESSION "
            + "WHERE ((((IIf([T_TOP2000_STARTOFRECORDINGSESSION].[sShift]=\"\",\"Sin Turno\",[T_TOP2000_STARTOFRECORDINGSESSION].[sShift])))<>\"Pausa\" And ((IIf([T_TOP2000_STARTOFRECORDINGSESSION].[sShift]=\"\",\"Sin Turno\",[T_TOP2000_STARTOFRECORDINGSESSION].[sShift])))<>\"Mantenimiento\") AND (T_TOP2000_STARTOFRECORDINGSESSION.dDate>'2022/02/28') AND "
            + "((T_TOP2000_STARTOFRECORDINGSESSION.iCenterId)=2) AND ((T_TOP2000_STARTOFRECORDINGSESSION.iMachineId)=?))";
        String querySQL = "SELECT IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\") & IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\") & ((([iSortModuleId]*6) -6))+ [iOutput] AS posicion, count(t_top2000_emptytrayinsertedfault.iOutput) AS fallos "
            + "FROM t_top2000_emptytrayinsertedfault "
            + "WHERE (((t_top2000_emptytrayinsertedfault.iSessionNumber) In (" + recordingBase + "))) "
            + "GROUP BY IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\"), IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\"), ((([iSortModuleId]*6) -6))+ [iOutput] "
            + "ORDER BY 4 DESC;";
        List<FallosFracasoSalidaEntrante> results = jdbcTemplate.query(querySQL, this::mapRowToFracasoSalidaEntrante, maquina);
        return results ;
    }

    private FallosFracasoSalidaEntrante mapRowToFracasoSalidaEntrante(ResultSet row, int rowNum) throws SQLException {
        return new FallosFracasoSalidaEntrante(
                row.getString("Posicion"),
                row.getInt("fallos"));
    }    

    
    

}
