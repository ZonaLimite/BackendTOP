package es.bogaservic.backendTOP.models;

import java.io.Serializable;


import lombok.Data;

@Data
public class ModelQuerier implements Serializable {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    int machineid;
    String fecha;
    String hora;
    String turno;
    String programa;
    String extraidas;
    
	public ModelQuerier(int machineid,String fecha, String hora, String turno, String programa, String extraidas) {
		super();
	}

	public ModelQuerier() {
		super();
	}
	
	

}
