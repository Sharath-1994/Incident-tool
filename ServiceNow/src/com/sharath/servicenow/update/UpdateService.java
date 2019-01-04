package com.sharath.servicenow.update;

import java.sql.SQLException;

public class UpdateService {

	
	public static boolean updateService(IncidentBean inc) throws ClassNotFoundException, SQLException{
		
		boolean result = UpdateDAO.updateIncDAO(inc);
		return result;
		
	}
}
