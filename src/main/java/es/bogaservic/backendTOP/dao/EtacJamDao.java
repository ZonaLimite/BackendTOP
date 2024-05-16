/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.bogaservic.backendTOP.models.FaultsTwoFields;

/**
 *
 * @author DevelopePC
 */
@Repository
public class EtacJamDao implements IEtacJam {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<es.bogaservic.backendTOP.models.FaultsTwoFields> findEtacJamGroupBy(String center, String maquina, String fecha, String hora, String turno, String programa) {
        String iSessionsCriteria = StartOfRecordingSessionDao_JDBC.makeQuerySessionsCriteria(center, maquina, fecha, hora, turno, programa);
        String querySQL="SELECT T_TOP2000_ETACJAM.sOutput AS name, count (sOutput) AS value " 
                        +"FROM T_TOP2000_ETACJAM " 
                        +"WHERE T_TOP2000_ETACJAM.iSessionNumber In(" + iSessionsCriteria + ") "
                        +"GROUP BY sOutput "
                        +"ORDER BY 1;";
    
        System.out.println("QuerySQL etac= " + querySQL);
        List<FaultsTwoFields> results = jdbcTemplate.query(querySQL, new BeanPropertyRowMapper<>(FaultsTwoFields.class));
        return results;
    }

}
