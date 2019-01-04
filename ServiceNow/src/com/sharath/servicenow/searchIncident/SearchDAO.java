package com.sharath.servicenow.searchIncident;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sharath.servicenow.createincident.ServiceNowDAO;

public class SearchDAO {

	public static IncidentBean checkDB(IncidentBean inc) throws ClassNotFoundException, SQLException {

		Connection con = ServiceNowDAO.getConnection();

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(
				"select * from public.incident_data where incident_number = '" + inc.getIncidentNumber() + "'");

		if (rs.next()) {
			inc.setIncidentNumber(rs.getInt("incident_number"));
			inc.setIncidentReportedUser(rs.getString("incident_loggedby"));
			inc.setApplicationImpacted(rs.getString("application_impacted"));
			inc.setContactNumber(rs.getLong("contact_number"));
			inc.setIncidentPriority(rs.getString("incident_priority"));
			inc.setShortDesciption(rs.getString("incident_short_description"));
			inc.setIncidentStatus(rs.getString("incident_status"));

			return inc;
		} else {
			if (inc.getIncidentReportedUser() == null) {

				return inc;
				
			}
		}

		return inc;

	}
}
