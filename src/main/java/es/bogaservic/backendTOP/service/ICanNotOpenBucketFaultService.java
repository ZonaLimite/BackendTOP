package es.bogaservic.backendTOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bogaservic.backendTOP.dao.IBucketNotProperlyClosedFaultDao_JDBC;
import es.bogaservic.backendTOP.models.FaultsTwoFields;
import es.bogaservic.backendTOP.models.OutputCarruselModel;

@Service
public interface ICanNotOpenBucketFaultService {

	List<OutputCarruselModel> canNotOpenBucketFaultDao_JDBC_GroupBy(String center, String maquina, String fecha, String hora, String turno, String programa);
}
