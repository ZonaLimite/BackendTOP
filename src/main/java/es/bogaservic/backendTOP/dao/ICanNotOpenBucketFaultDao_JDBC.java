package es.bogaservic.backendTOP.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import es.bogaservic.backendTOP.models.OutputCarruselModel;

@Repository
public interface ICanNotOpenBucketFaultDao_JDBC {
	List<OutputCarruselModel> canNotOpenBucketFaultDao_JDBC_GroupBy(String center, String maquina, String fecha, String hora, String turno, String programa);
}
