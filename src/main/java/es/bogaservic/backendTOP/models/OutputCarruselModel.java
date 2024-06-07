package es.bogaservic.backendTOP.models;

import java.io.Serializable;
import java.util.StringTokenizer;

import es.bogaservic.backendTOP.util.CubaTool;

public class OutputCarruselModel implements Serializable {
	
	CubaTool cubaTool = new CubaTool();
	
	private static final long serialVersionUID = 1L;
	String name;
	String value;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		StringTokenizer st = new StringTokenizer(name,"-");
		String nivel = st.nextToken();//EL nivel del carrusel
		this.name = nivel+"-"+cubaTool.convertToIHMCuba(Integer.parseInt(st.nextToken()));
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String fallos) {
		this.value = fallos;
	}
	
	
}
