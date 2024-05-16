package es.bogaservic.backendTOP.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.bogaservic.backendTOP.models.InputLineItem;

@Repository
public class InputLineItems implements IInputLineItemsDao_JDBC {

    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public List<InputLineItem> inputLineItemsSumed(String center, String maquina, String fecha, String hora,String turno, String programa) {
		
		  String iSessionsCriteria = StartOfRecordingSessionDao_JDBC.makeQuerySessionsCriteria(center, maquina, fecha, hora, turno, programa);
		  
		  String querySQL = "SELECT iInputLineId, sum (iInjectedItems) AS InjectedItems, sum(iSortedFinalised) as SortedFinalised, sum(iCullingRejectOld) AS CullingRejectOld, sum(iMailpieceAppeared) AS MailpieceAppeared, sum(iOutOfSlotTooLate) AS OutOfSlotTooLate, sum(iOutOfSlotTooEarly) AS SlotTooEarly, sum(iInjectableCollision) AS InjectableCollision, sum(iUnInjectableCollision) AS UnInjectableCollision, sum( iTooThick) AS TooThick, sum(iTooHigh) AS TooHigh, sum(iTooLong) AS TooLong, sum( iTooShort) AS TooShort,sum(iUnavailableBucket) as UnavailableBucket,  sum(iTooCloseToCulledItem) AS TooCloseToCulledItem, sum(iCullingReject) AS CullingReject "
		  		+ "FROM T_TOP2000_INPUTLINEITEMS "
		  		+ "WHERE iSessionNumber In(" + iSessionsCriteria + ") "
		  		+ "GROUP BY iInputLineId "
		  		+ "ORDER BY iInputLineId;"
		  		;
		  System.out.println("QuerySQL InputLineItems= " + querySQL);
		  List<InputLineItem> results = jdbcTemplate.query(querySQL, new BeanPropertyRowMapper<>(InputLineItem.class));
		  
		return results;
	}

   
}