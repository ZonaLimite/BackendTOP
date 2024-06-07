package es.bogaservic.backendTOP.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.bogaservic.backendTOP.models.FaultsTwoFields;
import es.bogaservic.backendTOP.models.OutputCarruselModel;

@Repository
public class CanNotOpenBucketFaultGroupBy implements ICanNotOpenBucketFaultDao_JDBC {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<OutputCarruselModel> canNotOpenBucketFaultDao_JDBC_GroupBy(String center, String maquina,
			String fecha, String hora, String turno, String programa) {
		String iSessionsCriteria = StartOfRecordingSessionDao_JDBC.makeQuerySessionsCriteria(center, maquina, fecha,
				hora, turno, programa);
		String querySQL = "SELECT sCarrousel & \"-\"& iGodet AS name, count(T_TOP2000_CANNOTOPENBUCKET.iGodet) AS value "
				+ "FROM T_TOP2000_CANNOTOPENBUCKET "
				+ "WHERE iSessionNumber IN (" + iSessionsCriteria + ") "
				+ "GROUP BY sCarrousel & \"-\"& iGodet;";

		System.out.println("QuerySQL canNotOpenBucketFault= " + querySQL);
		List<OutputCarruselModel> results = jdbcTemplate.query(querySQL,
				new BeanPropertyRowMapper<>(OutputCarruselModel.class));
		return results;
	}

}
