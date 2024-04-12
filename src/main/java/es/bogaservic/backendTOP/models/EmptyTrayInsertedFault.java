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
    Integer centro;
    Integer maquina;
    String fecha;
    String hora;
    String nivel;
    String lado;
    int salida;
    //int fallos;

    public EmptyTrayInsertedFault() {
    }

    public EmptyTrayInsertedFault(Integer centro, Integer maquina, String fecha, String hora, String nivel, String lado, int salida) {
        this.centro = centro;
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
        return "centro:"+centro+",maquina:"+maquina+",fecha:"+fecha+",hora:"+hora+" "+this.nivel + this.lado+this.salida;
    }
}
