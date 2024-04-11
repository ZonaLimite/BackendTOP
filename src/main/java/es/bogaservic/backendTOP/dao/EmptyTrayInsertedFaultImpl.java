/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DevelopePC
 */
@Repository
public class EmptyTrayInsertedFaultImpl implements EmptyTrayInsertedFault_Repository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<EmptyTrayInsertedFault> findEmptyTrayInsertedFaults(Integer center, Integer maquina, String fecha, String hora, String turno, String programa) {

        String iSessionsCriteria = StartOfRecordingSessionImpl.makeQuerySessionsCriteria(center, maquina, fecha, hora, turno, programa);
        
        System.out.println(iSessionsCriteria);
                String querySQL = "SELECT IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\") AS nivel, IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\") AS lado, ((([iSortModuleId]*6) -6))+ [iOutput] AS salida, count(t_top2000_emptytrayinsertedfault.iOutput) AS fallos "
                + "FROM t_top2000_emptytrayinsertedfault "
                + "WHERE (((t_top2000_emptytrayinsertedfault.iSessionNumber) In (" + iSessionsCriteria + "))) "
                + "GROUP BY IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\"), IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\"), ((([iSortModuleId]*6) -6))+ [iOutput] "
                + "ORDER BY 4,1,2,3 ASC;";
        //System.out.println(querySQL);
        //List<FallosFracasoSalidaEntrante> results = jdbcTemplate.query(querySQL, this::mapRowToFracasoSalidaEntrante, new Object[]{2,maquina});
        List<EmptyTrayInsertedFault> results = jdbcTemplate.query(querySQL, new BeanPropertyRowMapper(EmptyTrayInsertedFault.class));
        return results;
    }
}


