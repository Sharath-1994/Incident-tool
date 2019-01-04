package com.sharath.servicenow.filterIncidentdata;

public abstract class  IncidentMethodParameter {

	//public abstract List<IncidentBean> filter(String name) throws SQLException, ClassNotFoundException;
	
	public abstract IncidentBean filter(String name, String restored);
	
}
