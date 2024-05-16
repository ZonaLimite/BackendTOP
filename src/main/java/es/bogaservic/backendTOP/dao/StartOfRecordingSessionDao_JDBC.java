/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.bogaservic.backendTOP.models.StartOfRecordingSession;

/**
 *
 * @author F.J. BOGA
 *
 */
@Repository
public class StartOfRecordingSessionDao_JDBC implements IStartOfRecordingSessionDao {

	Logger logger = LoggerFactory.getLogger(StartOfRecordingSessionDao_JDBC.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<StartOfRecordingSession> findAll() {
		String query = "SELECT * FROM T_TOP2000_STARTOFRECORDINGSESSION ORDER By sFullTime DESC";
			
		logger.info("Query findAll : " + query);
		// BeanPropertyRowMapper permite mapear automt. basado en la clase proporcionada
		// return jdbcTemplate.query(query, new
		// BeanPropertyRowMapper(StartOfRecordingSession.class));
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<StartOfRecordingSession>(StartOfRecordingSession.class));

	}
	@Override
	public List<StartOfRecordingSession> findAllByMachine(int idMachine) {
		String query = "SELECT * FROM T_TOP2000_STARTOFRECORDINGSESSION WHERE iMachineId = "+ idMachine + " ORDER By sFullTime DESC";
			
		logger.info("Query findAll : " + query);
		// BeanPropertyRowMapper permite mapear automt. basado en la clase proporcionada
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<StartOfRecordingSession>(StartOfRecordingSession.class));

	}

	@Override
	public List<StartOfRecordingSession> findByCustom(String center, String maquina, String fecha, String hora,String turno, String programa) {

		String iSessionsCriteria = StartOfRecordingSessionDao_JDBC.makeQuerySessionsCriteria(center, maquina, fecha,
				hora, turno, programa);
		String query = "SELECT * FROM T_TOP2000_STARTOFRECORDINGSESSION "
				      +"WHERE T_TOP2000_STARTOFRECORDINGSESSION.iSessionNumber In (" + iSessionsCriteria + ") ";

		logger.info("Query findByDate : " + query);
		// BeanPropertyRowMapper permite mapear automt. basado en la clase proporcionada
		return jdbcTemplate.query(query,
				new BeanPropertyRowMapper<>(StartOfRecordingSession.class));
	}

	public static String makeQuerySessionsCriteria(String center, String maquina, String fecha, String hora,
			String turno, String programa) {

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
			recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.dDate BETWEEN " + fecha + " ";//de la forma '2024/04/01' AND '2024/04/02'
		}

		if ((hora != null)) {
			recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.hTime BETWEEN " + hora + " ";//de la forma '00:00:00' AND '01:00:00'
		}
		if (programa != null) {
			recordingBase += "AND T_TOP2000_STARTOFRECORDINGSESSION.sExploitationPlan = '" + programa + "' ";
		}
		return recordingBase;
	}
	
}
