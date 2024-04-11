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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    @Override
    public List<T_TOP2000_STARTOFRECORDINGSESSION> findAll() {
        String query = "select * FROM T_TOP2000_STARTOFRECORDINGSESSION";
        
        List<T_TOP2000_STARTOFRECORDINGSESSION> 
                results = jdbcTemplate.query(query,new BeanPropertyRowMapper(T_TOP2000_STARTOFRECORDINGSESSION.class));
        return results;
    }
    @Override
    public List<FallosFracasoSalidaEntrante> findByMaquina(int centro,int maquina) {
        String recordingBase = "SELECT T_TOP2000_STARTOFRECORDINGSESSION.iSessionNumber "
            + "FROM T_TOP2000_STARTOFRECORDINGSESSION "
            + "WHERE ((((IIf([T_TOP2000_STARTOFRECORDINGSESSION].[sShift]=\"\",\"Sin Turno\",[T_TOP2000_STARTOFRECORDINGSESSION].[sShift])))<>\"Pausa\" And ((IIf([T_TOP2000_STARTOFRECORDINGSESSION].[sShift]=\"\",\"Sin Turno\",[T_TOP2000_STARTOFRECORDINGSESSION].[sShift])))<>\"Mantenimiento\") AND (T_TOP2000_STARTOFRECORDINGSESSION.dDate = '2024/04/01') AND "
            + "((T_TOP2000_STARTOFRECORDINGSESSION.iCenterId)=?) AND ((T_TOP2000_STARTOFRECORDINGSESSION.iMachineId)=?))";
        String querySQL = "SELECT IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\") AS nivel, IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\") AS lado, ((([iSortModuleId]*6) -6))+ [iOutput] AS salida, count(t_top2000_emptytrayinsertedfault.iOutput) AS fallos "
            + "FROM t_top2000_emptytrayinsertedfault "
            + "WHERE (((t_top2000_emptytrayinsertedfault.iSessionNumber) In (" + recordingBase + "))) "
            + "GROUP BY IIf(t_top2000_emptytrayinsertedfault.iSortModuleLevel=1,\"A\",\"B\"), IIf(t_top2000_emptytrayinsertedfault.iSortModuleSide=1,\"F\",\"T\"), ((([iSortModuleId]*6) -6))+ [iOutput] "
            + "ORDER BY 4,1,2,3 ASC;";
        System.out.println(querySQL);
        //List<FallosFracasoSalidaEntrante> results = jdbcTemplate.query(querySQL, this::mapRowToFracasoSalidaEntrante, new Object[]{2,maquina});
        List<FallosFracasoSalidaEntrante> results = jdbcTemplate.query(querySQL,new BeanPropertyRowMapper(FallosFracasoSalidaEntrante.class), new Object[]{centro,maquina});
        return results ;
    }

  

    
    

}
