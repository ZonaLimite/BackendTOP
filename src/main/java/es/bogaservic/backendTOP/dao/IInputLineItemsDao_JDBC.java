package es.bogaservic.backendTOP.dao;

import java.util.List;

import es.bogaservic.backendTOP.models.FaultsTwoFields;
import es.bogaservic.backendTOP.models.InputLineItem;

public interface IInputLineItemsDao_JDBC {

	    List<InputLineItem> inputLineItemsSumed(String center, String maquina, String fecha, String hora, String turno, String programa);

}
