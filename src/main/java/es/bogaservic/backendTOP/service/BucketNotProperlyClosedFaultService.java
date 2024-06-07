package es.bogaservic.backendTOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.util.ConcurrentBag.IBagStateListener;

import es.bogaservic.backendTOP.dao.IBucketNotProperlyClosedFaultDao_JDBC;
import es.bogaservic.backendTOP.models.OutputCarruselModel;

@Service
public class BucketNotProperlyClosedFaultService implements IBucketNotProperlyClosedFaultService {

	@Autowired
	IBucketNotProperlyClosedFaultDao_JDBC BNPC_Dao;
	
	@Override
	public List<OutputCarruselModel> bucketNotProperlyClosedFaultDao_JDBC_GroupBy(String center, String maquina,
			String fecha, String hora, String turno, String programa) {
			return BNPC_Dao.bucketNotProperlyClosedFaultDao_JDBC_GroupBy(center, maquina, fecha, hora, turno, programa);
	}

}
	