/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import es.bogaservic.backendTOP.models.StartOfRecordingSession;
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
public class StartOfRecordingSessionDao_JDBC implements IStartOfRecordingSessionDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<StartOfRecordingSession> findAll() {
        String query = "select * FROM T_TOP2000_STARTOFRECORDINGSESSION";

        //BeanPropertyRowMapper permite mapear automt. basado en la clase proporcionada
        return jdbcTemplate.query(query, new BeanPropertyRowMapper(StartOfRecordingSession.class));

    }

    public static String makeQuerySessionsCriteria(Integer center, Integer maquina, String fecha, String hora, String turno, String programa) {

        String recordingBase = "SELECT T_TOP2000_STARTOFRECORDINGSESSION.iSessionNumber "
                + "FROM T_TOP2000_STARTOFRECORDINGSESSION ";
        if (turno == null) {
            recordingBase += "WHERE IIf([T_TOP2000_STARTOFRECORDINGSESSION].[sShift]=\"\",\"Sin Turno\",[T_TOP2000_STARTOFRECORDINGSESSION].[sShift])<>\"Pausa\" And IIf([T_TOP2000_STARTOFRECORDINGSESSION].[sShift]=\"\",\"Sin Turno\",[T_TOP2000_STARTOFRECORDINGSESSION].[sShift])<>\"Mantenimiento\" ";
        } else {
            recordingBase += "WHERE [T_TOP2000_STARTOFRECORDINGSESSION].[sShift]='" + turno + "' ";
        }

        if (center != null) {
            recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.iCenterId=" + center + " ";
        }

        if (maquina != null) {
            recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.iMachineId=" + maquina + " ";
        }

        if ((fecha != null)) {
            recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.dDate = '" + fecha + "' ";
        }

        if ((hora != null)) {
            recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.hTime = '" + hora + "' ";
        }

        if (turno != null) {
            recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.sShift = '" + turno + "' ";
        }

        if (programa != null) {
            recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.sSploitationPlan = '" + programa + "' ";
        }
        return recordingBase;
    }

    @Override
    public List<StartOfRecordingSession> findByDate(String sDate) {
        String query = "SELECT T_TOP2000_STARTOFRECORDINGSESSION.* "
                + "FROM T_TOP2000_EMPTYTRAYINSERTEDFAULT, T_TOP2000_STARTOFRECORDINGSESSION "
                + "WHERE [T_TOP2000_STARTOFRECORDINGSESSION]![dDate]='"+sDate+"';";

        //BeanPropertyRowMapper permite mapear automt. basado en la clase proporcionada
        return jdbcTemplate.query(query, new BeanPropertyRowMapper(StartOfRecordingSession.class));
    }

}
