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
    String posicion;
    int fallos;

    public FallosFracasoSalidaEntrante(String posicion, int fallos) {
        this.posicion = posicion;
        this.fallos = fallos;
    }
    
    
}
