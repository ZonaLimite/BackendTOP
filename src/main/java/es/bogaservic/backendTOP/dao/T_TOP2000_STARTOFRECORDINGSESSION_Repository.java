/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package es.bogaservic.backendTOP.dao;

import es.bogaservic.backendTOP.models.FallosFracasoSalidaEntrante;
import es.bogaservic.backendTOP.models.T_TOP2000_STARTOFRECORDINGSESSION;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author F.J. BOGA
 */
public interface T_TOP2000_STARTOFRECORDINGSESSION_Repository {
    List<T_TOP2000_STARTOFRECORDINGSESSION> findAll();
    List<FallosFracasoSalidaEntrante> findByMaquina(int centro,int maquina);
    
    
}
