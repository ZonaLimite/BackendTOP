package es.bogaservic.backendTOP.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class UtilDateTime {
	public static Map<String,String> convertDatedTime(String fecha, String horas, ZoneId zId, ZoneId zIdTarget){
		Map<String,String> mapnewDates = new LinkedHashMap<String, String>();
    	
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
    	//ZoneId zId = ZoneId.of("UTC+0");
    

    	ZonedDateTime zdt = ZonedDateTime.of(lDate, lTime, zId);
    	
    	Instant instant = zdt.toInstant(); //Un instante del valor de fecha original del BlastIndex (Que es UTC+0)
    	//ZoneId zIdNew = ZoneId.systemDefault();
    	ZonedDateTime zdtNew = instant.atZone(zIdTarget); //Un nuevoZonedDateTime aplicando la zona horaria
    
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
     
        String newHora =  hora+":"+minutos+":"+segundos;
        String newFecha = year+"/"+mes+"/"+dia;
        mapnewDates.put("fecha", newFecha);
        mapnewDates.put("hora", newHora);
        return mapnewDates;
        
      
         
	}
}
