/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import es.bogaservic.backendTOP.models.FaultsTwoFields;

/**
 *
 * @author DevelopePC
 */
@Repository
public class EmptyTrayInsertedFaultDao_JDBC implements IEmptyTrayInsertedFaultDao_JDBC {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<EmptyTrayInsertedFault> findEmptyTrayInsertedFaults(String center, String maquina, String fecha, String hora, String turno, String programa) {

        String iSessionsCriteria = StartOfRecordingSessionDao_JDBC.makeQuerySessionsCriteria(center, maquina, fecha, hora, turno, programa);
        System.out.println("Criteria = " + iSessionsCriteria);

        String querySQL = "SELECT "
                + "iCenterId AS center, "
                + "iMachineId AS maquina, "
                + "dDate AS fecha, "
                + "htime AS hora, "
                /* /Pendiente pensar si las consultas de agrupacion se hacen en SQL o con Streams/*/
                + "IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\") AS nivel, "
                + "IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\") AS lado, "
                + "((([iSortModuleId]*6) -6)+ [iOutput]) AS salida "
                + "FROM t_top2000_emptytrayinsertedfault "
                + "WHERE t_top2000_emptytrayinsertedfault.iSessionNumber In (" + iSessionsCriteria + ") "
                //+ "GROUP BY IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\"), IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\"), ((([iSortModuleId]*6) -6))+ [iOutput] "
                + "ORDER BY 3,4 DESC;";

        System.out.println("QuerySQL = " + querySQL);
        List<EmptyTrayInsertedFault> results = jdbcTemplate.query(querySQL, new BeanPropertyRowMapper<EmptyTrayInsertedFault>(EmptyTrayInsertedFault.class));
        return results;
    }

    @Override
    public List<FaultsTwoFields> findEmptyTrayInsertedFaultsGroupBy(String center, String maquina, String fecha, String hora, String turno, String programa) {
        String iSessionsCriteria = StartOfRecordingSessionDao_JDBC.makeQuerySessionsCriteria(center, maquina, fecha, hora, turno, programa);
        System.out.println("Criteria = " + iSessionsCriteria);
        String querySQL = "SELECT "
                + "IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\") AS nivel, "
                + "IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\") AS lado, "
                + "((([iSortModuleId]*6) -6)+ [iOutput]) AS salida, "
                + "count (*) AS fallos "
                + "FROM t_top2000_emptytrayinsertedfault "
                + "WHERE t_top2000_emptytrayinsertedfault.iSessionNumber In (" + iSessionsCriteria + ") "
                + "GROUP BY IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\"), IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\"), ((([iSortModuleId]*6) -6))+ [iOutput] "
                + "ORDER BY 1,2 DESC;";
        System.out.println("Query SQL etifGroupBy = " + querySQL);
        return jdbcTemplate.query(querySQL, 
                new RowMapper<FaultsTwoFields>() {
                    public FaultsTwoFields mapRow(ResultSet rs, int rowNum)throws SQLException {
                        return new FaultsTwoFields(
                                rs.getString("nivel")+ rs.getString("lado")+ rs.getString("salida"),
                                rs.getInt("fallos"));
                    }
                }
        );

    }
}
