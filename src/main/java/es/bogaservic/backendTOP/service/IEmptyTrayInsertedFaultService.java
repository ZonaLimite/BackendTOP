/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.bogaservic.backendTOP.service;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import java.util.List;

/**
 *
 * @author F.J. BOGA
 */
public interface IEmptyTrayInsertedFaultService {
    List<EmptyTrayInsertedFault> findEmptyTrayInsertedFaults(Integer center, Integer maquina, String fecha, String hora, String turno, String programa);
}
