package es.bogaservic.backendTOP.service;

import java.util.List;

import org.springframework.stereotype.Service;
import es.bogaservic.backendTOP.models.InputLineItem;

@Service
public interface IInputLineItemsService {
	public List<InputLineItem> findInputLineItemsSumed(String center, String maquina, String fecha, String hora, String turno, String programa);
}
