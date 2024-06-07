package es.bogaservic.backendTOP.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.bogaservic.backendTOP.models.FaultsTwoFields;

@Repository
public class UnloadingElectroimanFaultGroupBy implements IUnloadingElectroimanFaultDao_JDBC {
	
	@Autowired
	    JdbcTemplate jdbcTemplate;
	@Override
	public List<FaultsTwoFields> unloadingElectroimanFaultDao_JDBC_GroupBy(String center, String maquina, String fecha,
			String hora, String turno, String programa) {
		String iSessionsCriteria = StartOfRecordingSessionDao_JDBC.makeQuerySessionsCriteria(center, maquina, fecha, hora, turno, programa);
        String querySQL="SELECT  sSortie AS name, count(sSortie) AS value "
        		+ "FROM T_TOP2000_UNLOADINGERROR "
        		+ "WHERE iSessionNumber IN (" + iSessionsCriteria + ") "
        		+ "GROUP BY sSortie "
        		+ "ORDER BY 1;";
        	
        	
    
        System.out.println("QuerySQL unloadinErrors= " + querySQL);
        List<FaultsTwoFields> results = jdbcTemplate.query(querySQL, new BeanPropertyRowMapper<>(FaultsTwoFields.class));
        return results;
	}

}
