package com.sharath.servicenow.createincident;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;


public class ServiceNowDAO {

	public static boolean connectToDb(IncidentBean incident) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();

		Statement statement = conn.createStatement();

		ResultSet rs = statement.executeQuery("SELECT count(*)FROM public.incident_data;");
		int increment = 0;

		if (rs.next()) {
			int i = rs.getInt(1);
			increment = i + 1;
		}
		
		incident.setIncidentNumber(increment);

		PreparedStatement st = conn.prepareStatement("INSERT INTO public.incident_data " + ""
				+ "(incident_number, incident_loggedby, application_impacted, incident_status, incident_short_description, incident_priority, contact_number) "
				+ "" + "	VALUES (?, ?, ?, ?, ?, ?, ?);");

		st.setInt(1, incident.getIncidentNumber());
		st.setString(2, incident.getIncidentReportedUser());
		st.setString(3, incident.getApplicationImpacted());
		st.setString(4, incident.getIncidentStatus());
		st.setString(5, incident.getShortDesciption());
		st.setString(6, incident.getIncidentPriority());
		st.setLong(7, incident.getContactNumber());

		int i = st.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/incident_db", "postgres", "ikon4774");
	}

}
