/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.service;

import es.bogaservic.backendTOP.dao.EtacJamDao;
import es.bogaservic.backendTOP.dao.IEtacJam;
import es.bogaservic.backendTOP.models.FaultsTwoFields;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DevelopePC
 *
 */
@Service
public class EtacJamService implements IEtacJamService {

    @Autowired
    private IEtacJam EJ_Repo;

    @Override
    public List<FaultsTwoFields> findEtacJamGroupBy(String center, String maquina, String fecha, String hora, String turno, String programa) {
       return EJ_Repo.findEtacJamGroupBy(center, maquina, fecha, hora, turno, programa);
    }

}
