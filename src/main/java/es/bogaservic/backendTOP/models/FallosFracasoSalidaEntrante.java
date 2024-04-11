/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.models;

import lombok.Data;

/**
 *
 * @author F.J. BOGA
 */
@Data
public class FallosFracasoSalidaEntrante {
    String nivel;
    String lado;
    int salida;
    int fallos;

    public FallosFracasoSalidaEntrante() {
    }

    public FallosFracasoSalidaEntrante(String nivel, String lado, int salida,int fallos) {
        this.nivel= nivel;
        this.lado= lado;
        this.salida = salida;
        this.fallos = fallos;
    }
    
    @Override
    public String toString(){
        return this.nivel + this.lado+this.salida + "=" + this.fallos;
    }
}
