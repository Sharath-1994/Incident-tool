package com.sharath.servicenow.filterIncidentdata;

import java.sql.SQLException;
import java.util.List;


public class FilterService {

	
	public static List<IncidentBean> serviceFilter (String name, int statusCode) throws ClassNotFoundException, SQLException {
		
		List<IncidentBean> service = FilterDAO.getDataFromDB(name, statusCode);
		
		return service;
	}

	
}
