package es.bogaservic.backendTOP.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import net.ucanaccess.jdbc.UcanaccessSQLException;

@ControllerAdvice
public class ApiExceptionHandler {
		@ExceptionHandler(org.hsqldb.HsqlException.class)
		public void handleHsqlException(Exception ex) {
			System.err.println("Exception Hsql:" +ex);
		}

		@ExceptionHandler(value = Exception.class)
		public void handleException(Exception ex) {
			System.err.println("Exception (message):" +ex);
		}
		
		@ExceptionHandler(UcanaccessSQLException.class)
		public void handleUcanAccessException(Exception ex) {
			System.err.println("Exception UcannAccess:" +ex);
		}
		@ExceptionHandler(java.sql.SQLNonTransientConnectionException.class)
		public void handleSQLException(Exception ex) {
			System.err.println("Exception Hsql:" +ex);
		}

		
		
		
		
}
