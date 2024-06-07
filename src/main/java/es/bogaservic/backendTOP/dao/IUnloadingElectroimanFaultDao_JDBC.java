package es.bogaservic.backendTOP.dao;

import java.util.List;

import es.bogaservic.backendTOP.models.FaultsTwoFields;

public interface IUnloadingElectroimanFaultDao_JDBC {
	List<FaultsTwoFields> unloadingElectroimanFaultDao_JDBC_GroupBy(String center, String maquina, String fecha, String hora, String turno, String programa);
}
