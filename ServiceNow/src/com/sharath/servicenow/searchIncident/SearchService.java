package com.sharath.servicenow.searchIncident;

import java.sql.SQLException;

public class SearchService {

	
	public static IncidentBean serviceLayer(IncidentBean inc) throws ClassNotFoundException, SQLException{
		
		IncidentBean intResult = SearchDAO.checkDB(inc);
		return intResult;
	}
}
