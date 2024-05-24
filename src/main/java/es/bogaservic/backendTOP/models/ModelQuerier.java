package es.bogaservic.backendTOP.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class ModelQuerier implements Serializable {
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    int imachineid;
    String Fecha;
    String Hora;
    String Turno;
    String Programa;
    String Extraidas;
    
	public ModelQuerier() {
		super();
	}

}
