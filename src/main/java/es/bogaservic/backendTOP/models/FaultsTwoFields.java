/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.models;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author DevelopePC
 */
@Data
public class FaultsTwoFields implements Serializable{
    String name;
    int value;

    public FaultsTwoFields() {
    }

    public FaultsTwoFields(String device, int fallos) {
        this.name = device;
        this.value = fallos;
    }
    
    
}
