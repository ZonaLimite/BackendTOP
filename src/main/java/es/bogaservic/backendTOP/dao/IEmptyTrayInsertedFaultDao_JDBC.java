/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import es.bogaservic.backendTOP.models.FaultsTwoFields;
import java.util.List;

/**
 *
 * @author DevelopePC
 */
public interface IEmptyTrayInsertedFaultDao_JDBC {
    List<EmptyTrayInsertedFault> findEmptyTrayInsertedFaults(String center, String maquina, String fecha, String hora, String turno, String programa);
    List<FaultsTwoFields> findEmptyTrayInsertedFaultsGroupBy(String center, String maquina, String fecha, String hora, String turno, String programa);
    
}
