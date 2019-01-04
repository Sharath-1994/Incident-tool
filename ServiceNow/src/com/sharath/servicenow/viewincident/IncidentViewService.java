package com.sharath.servicenow.viewincident;

import java.sql.SQLException;
import java.util.List;

public class IncidentViewService {

	public static List<IncidentBean> serviceList() throws ClassNotFoundException, SQLException{
		
		List<IncidentBean> incidentService = IncidentDAO.getData();
		
		return incidentService;
		
	}
	
}
