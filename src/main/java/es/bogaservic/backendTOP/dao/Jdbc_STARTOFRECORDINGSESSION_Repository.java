/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

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
                this::mapRowToSession);
        return results;
    }

    private T_TOP2000_STARTOFRECORDINGSESSION mapRowToSession(ResultSet row, int rowNum) throws SQLException {
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

}
