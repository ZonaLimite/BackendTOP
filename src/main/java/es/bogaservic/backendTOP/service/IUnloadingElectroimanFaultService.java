package es.bogaservic.backendTOP.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.bogaservic.backendTOP.models.FaultsTwoFields;

@Service
public interface IUnloadingElectroimanFaultService {
	 public List<FaultsTwoFields> findUnloadingElectroimanFaultGroupBy(String center, String maquina, String fecha, String hora, String turno, String programa);
}
