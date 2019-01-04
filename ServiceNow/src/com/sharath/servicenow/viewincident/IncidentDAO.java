package com.sharath.servicenow.viewincident;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.sharath.servicenow.createincident.ServiceNowDAO;;

public class IncidentDAO {

	public static List<IncidentBean> getData() throws ClassNotFoundException, SQLException{

	
		Connection con = ServiceNowDAO.getConnection();

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(
				"SELECT * FROM public.incident_data order by incident_number;");

		List<IncidentBean> incidentDataDAO = new ArrayList<IncidentBean>();
		
		while (rs.next()) {
			IncidentBean inc = new IncidentBean();
			inc.setIncidentNumber(rs.getInt("incident_number"));
			inc.setIncidentReportedUser(rs.getString("incident_loggedby"));
			inc.setApplicationImpacted(rs.getString("application_impacted"));
			inc.setContactNumber(rs.getLong("contact_number"));
			inc.setIncidentStatus(rs.getString("incident_status"));
			inc.setShortDesciption(rs.getString("incident_short_description"));
			inc.setIncidentPriority(rs.getString("incident_priority"));
			
			incidentDataDAO.add(inc);
			
		}
		return incidentDataDAO;

	}
}
