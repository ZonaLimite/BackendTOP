package es.bogaservic.backendTOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bogaservic.backendTOP.dao.IUnloadingElectroimanFaultDao_JDBC;
import es.bogaservic.backendTOP.models.FaultsTwoFields;

@Service
public class UnloadingElectroimanFaultService implements IUnloadingElectroimanFaultService {

	@Autowired
	    private IUnloadingElectroimanFaultDao_JDBC UEFD_Repo;

	@Override
	public List<FaultsTwoFields> findUnloadingElectroimanFaultGroupBy(String center, String maquina, String fecha,
			String hora, String turno, String programa) {
		// TODO Auto-generated method stub
		return UEFD_Repo.unloadingElectroimanFaultDao_JDBC_GroupBy(center, maquina, fecha, hora, turno, programa);
	}

}
