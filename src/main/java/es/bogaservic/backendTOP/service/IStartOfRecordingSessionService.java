/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.bogaservic.backendTOP.service;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import es.bogaservic.backendTOP.models.StartOfRecordingSession;
import java.util.List;

/**
 *
 * @author F.J. BOGA
 */
public interface IStartOfRecordingSessionService {
      List<StartOfRecordingSession> findAll();
      List<StartOfRecordingSession> findByCustom(String center, String maquina, String fecha, String hora, String turno, String programa);
    
}
