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
import java.util.StringTokenizer;

import org.springframework.jdbc.core.RowMapper;

import es.bogaservic.backendTOP.models.ModelQuerier;

public class CustomerRowMapper implements RowMapper<ModelQuerier> {

    @Override
    public ModelQuerier mapRow(ResultSet row, int rowNum) throws SQLException {
    	
    	ModelQuerier mq = new ModelQuerier();

    	int imachineid = row.getInt("imachineid");
    	mq.setMachineid(imachineid);
    	
    	//Adaptacion de la hora para mostrar la hora local (UTC+2)
    	String fecha = row.getString("fecha");
    	String horas = row.getString("hora"); 
    	StringTokenizer tkf = new StringTokenizer(fecha,"/");
    	StringTokenizer tkh = new StringTokenizer(horas,":");
    	String year = tkf.nextToken();
    	String mes = tkf.nextToken();
    	String dia = tkf.nextToken();
    	
    	String hora = tkh.nextToken();
    	String minutos = tkh.nextToken();
    	String segundos = tkh.nextToken();
    	// Creacion de un ZoneId con el dato original (UTC+0)
       	LocalDate lDate = LocalDate.of(Integer.valueOf(year),Integer.valueOf(mes),Integer.valueOf(dia));
    	LocalTime lTime = LocalTime.of(Integer.valueOf(hora), Integer.valueOf(minutos),Integer.valueOf(segundos));
    	ZoneId zId = ZoneId.of("UTC+0");

    	ZonedDateTime zdt = ZonedDateTime.of(lDate, lTime, zId);
    	
    	Instant instant = zdt.toInstant(); //Un instante del valor de fecha original del BlastIndex (Que es UTC+0)
    	
    	ZonedDateTime zdtNew = instant.atZone(ZoneId.systemDefault()); //Un nuevoZonedDateTime aplicando la zona horaria
    
    	//Poner zeros delante al format horario si es menor de 10 con la nueva hora obtenida adaptada a nuestro IdZone
    	//Tratamiento digitos hora
    	if( zdtNew.getHour() < 10) {
    		hora = "0"+zdtNew.getHour();
    	}else {
    		hora = String.valueOf(zdtNew.getHour());
    	}
    	//Tratamiento digitos minutos
        if( zdtNew.getMinute() < 10) {
        	minutos = "0"+zdtNew.getMinute();
        }else {
        	minutos = String.valueOf(zdtNew.getMinute());
        }
    	//Tratamiento digitos segundos
    	if( zdtNew.getSecond()< 10) {
    		segundos = "0"+zdtNew.getSecond();
    	}else {
    		segundos = ""+zdtNew.getSecond();
    	}
    	
    	//Lo mismo con la fecha porque puede haber cambiado al aplicar el offset horario
    	
    	year = String.valueOf(zdtNew.getYear());
        if( zdtNew.getMonthValue() < 10) {
        	mes = "0"+zdtNew.getMonthValue();
        }else{
        	mes = ""+zdtNew.getMonthValue();
        }

        if( zdtNew.getDayOfMonth()< 10) {
        	dia = "0"+zdtNew.getDayOfMonth();
        }else{
        	dia = ""+zdtNew.getDayOfMonth();
        }
    	
    	mq.setHora(hora+":"+minutos+":"+segundos);
    	mq.setFecha(year+"/"+mes+"/"+dia);    	

    	String turno = row.getString("turno");
    	mq.setTurno(turno);
    	
    	String programa = row.getString("programa");
    	mq.setPrograma(programa);
    	
    	String extraidas = row.getString("extraidas");
    	mq.setExtraidas(extraidas);
 
    	
    	return mq;

    }
}
