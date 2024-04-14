/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.models;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author F.J. BOGA
 */
@Data
public class EmptyTrayInsertedFault implements Serializable{
    Integer center;
    Integer maquina;
    String fecha;
    String hora;
    String nivel;
    String lado;
    Integer salida;
    //int fallos;
  //Integer center, Integer maquina, String fecha, String hora, String turno, String programa) {
    public EmptyTrayInsertedFault() {
    }

    public EmptyTrayInsertedFault(Integer center, Integer maquina, String fecha, String hora,String nivel, String lado, Integer salida) {
        this.center = center;
        this.maquina = maquina;
        this.fecha = fecha;
        this.hora = hora;
        this.nivel = nivel;
        this.lado = lado;
        this.salida = salida;
        //this.fallos = fallos;
    }
    
    @Override
    public String toString(){
        return "centro:"+center+",maquina:"+maquina+",fecha:"+fecha+",hora:"+hora+" "+"nivel:"+this.nivel + "lado:"+this.lado+"salida:"+this.salida;
    }
    
    public String sPatd () {
    	return this.getNivel()+this.getLado()+this.getSalida();
    }
    
}
