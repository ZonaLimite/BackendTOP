package es.bogaservic.backendTOP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.bogaservic.backendTOP.dao.EtacJamDao;
import es.bogaservic.backendTOP.dao.IInputLineItemsDao_JDBC;
import es.bogaservic.backendTOP.models.InputLineItem;

@Service
public class InputLineItemsService implements IInputLineItemsService{

	 @Autowired
	    private IInputLineItemsDao_JDBC inputLineItems_Repo;
	
	@Override
	public List<InputLineItem> findInputLineItemsSumed(String center, String maquina, String fecha, String hora,
			String turno, String programa) {
			return inputLineItems_Repo.inputLineItemsSumed(center, maquina, fecha, hora, turno, programa);
	}

}
