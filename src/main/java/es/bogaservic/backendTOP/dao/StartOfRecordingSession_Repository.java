/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import es.bogaservic.backendTOP.models.StartOfRecordingSession;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author F.J. BOGA
 */
public interface StartOfRecordingSession_Repository {
    List<StartOfRecordingSession> findAll();
    List<EmptyTrayInsertedFault> findFracasos(String iSessionsCriteria);
    
    
}
