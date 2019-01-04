package com.sharath.servicenow.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO {
	

	public static boolean updateIncDAO(IncidentBean inc) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();

		PreparedStatement stmt = con.prepareStatement("UPDATE public.incident_data SET incident_status = ?"
				+ " where incident_number = " + inc.getIncidentNumber());

		stmt.setString(1, inc.getIncidentStatus());
		
		stmt.executeUpdate();
		return true;

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/incident_db", "postgres", "ikon4774");
	}
}
