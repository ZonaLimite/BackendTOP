/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.bogaservic.backendTOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bogaservic.backendTOP.dao.IEmptyTrayInsertedFaultDao_JDBC;
import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import es.bogaservic.backendTOP.models.FaultsTwoFields;

/**
 *
 * @author F.J. BOGA
 */
@Service
public class EmptyTrayInsertedFaultService implements IEmptyTrayInsertedFaultService {

	@Autowired
	private IEmptyTrayInsertedFaultDao_JDBC etif_Repo;

	@Override
	public List<EmptyTrayInsertedFault> findEmptyTrayInsertedFaults(String center, String maquina, String fecha,
			String hora, String turno, String programa) {
		return etif_Repo.findEmptyTrayInsertedFaults(center, maquina, fecha, hora, turno, programa);
	}
	
	@Override
	public List<FaultsTwoFields> findEmptyTrayInsertedFaultsGroupBy(String center, String maquina, String fecha,
			String hora, String turno, String programa) {
		
		return etif_Repo.findEmptyTrayInsertedFaultsGroupBy(center, maquina, fecha, hora, turno, programa);
		
	}

	

}
