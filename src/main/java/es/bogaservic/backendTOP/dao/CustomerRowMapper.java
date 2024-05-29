package es.bogaservic.backendTOP.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.jdbc.core.RowMapper;

import es.bogaservic.backendTOP.models.ModelQuerier;
import es.bogaservic.backendTOP.service.UtilDateTime;

public class CustomerRowMapper implements RowMapper<ModelQuerier> {

    @Override
    public ModelQuerier mapRow(ResultSet row, int rowNum) throws SQLException {
    	
    	ModelQuerier mq = new ModelQuerier();

    	int imachineid = row.getInt("imachineid");
    	mq.setMachineid(imachineid);
    	
    	Map<String,String> mapDates = UtilDateTime.convertDatedTime(row.getString("fecha"),row.getString("hora"), ZoneId.of("UTC"),ZoneId.systemDefault());
    	
    	mq.setHora(mapDates.get("hora"));
    	mq.setFecha(mapDates.get("fecha"));    	

    	String turno = row.getString("turno");
    	mq.setTurno(turno);
    	
    	String programa = row.getString("programa");
    	mq.setPrograma(programa);
    	
    	String extraidas = row.getString("extraidas");
    	mq.setExtraidas(extraidas);
 
    	
    	return mq;

    }
}
