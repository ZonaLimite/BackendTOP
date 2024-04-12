/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.service;

import es.bogaservic.backendTOP.models.StartOfRecordingSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.bogaservic.backendTOP.dao.IStartOfRecordingSessionDao;

/**
 *
 * @author F.J. BOGA
 */
@Service
public class StartOfRecordingSessionService implements IStartOfRecordingSessionService{

    @Autowired
    private IStartOfRecordingSessionDao SORS_Repo;//Inyectamos la interface dao de acceso al repositorio
    
    @Override
    public List<StartOfRecordingSession> findAll() {
       return SORS_Repo.findAll();
    }

    @Override
    public List<StartOfRecordingSession> findByDate(String sDate) {
        return SORS_Repo.findByDate(sDate);
    }
    
}
