package com.sharath.servicenow.createincident;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ServiceNowServiceLayer {

	private static final Logger logger = Logger.getLogger(ServiceNowServiceLayer.class);

	public boolean serviceLayer(IncidentBean incident) throws ClassNotFoundException, SQLException {
			
		
		
		boolean result = ServiceNowDAO.connectToDb(incident);
		
		logger.debug("Service to DAO called");
		
		return result;
	}
}
