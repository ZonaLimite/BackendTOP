/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import java.util.List;

/**
 *
 * @author DevelopePC
 */
public interface EmptyTrayInsertedFault_Repository {
    List<EmptyTrayInsertedFault> findEmptyTrayInsertedFaults(Integer center, Integer maquina, String fecha, String hora, String turno, String programa);
}
