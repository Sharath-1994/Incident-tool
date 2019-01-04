package com.sharath.servicenow.filterIncidentdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilterDAO {

	static PreparedStatement ps;

	public static List<IncidentBean> getDataFromDB(String name, int statusCode)
			throws ClassNotFoundException, SQLException {

		List<IncidentBean> listInc = new ArrayList<IncidentBean>();

		Connection con = getConnection();

		if (name != null && statusCode == 0) // get incidents which are active
												// and restored specific to user
			ps = userQueryStmt(con, name);
		else if (name.equals("") && statusCode > 0) // get incidents which are
													// active and restored
													// across all user
		ps = userQueryStmt(con, statusCode);

		else if (name != null && statusCode >= 0)
			ps = userQueryStmt(con, statusCode, name);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			IncidentBean incdata = new IncidentBean();
			incdata.setIncidentNumber(rs.getInt(1));
			incdata.setIncidentReportedUser(rs.getString(2));
			incdata.setApplicationImpacted(rs.getString(3));
			incdata.setIncidentStatus(rs.getString(4));
			incdata.setShortDesciption(rs.getString(5));
			incdata.setIncidentPriority(rs.getString(6));
			incdata.setContactNumber(rs.getLong(7));

			listInc.add(incdata);
		}
		return listInc;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/incident_db", "postgres", "ikon4774");
	}

	static PreparedStatement userQueryStmt(Connection conn, String loggedUserName) throws SQLException {

		ps = conn.prepareStatement(
				"Select * from public.incident_data where incident_loggedby = ? " + "order by incident_number ASC");

		ps.setString(1, loggedUserName);

		return ps;
	}

	static PreparedStatement userQueryStmt(Connection conn, int statusCode) throws SQLException {

		ps = conn.prepareStatement("Select * from public.incident_data where incident_status = ?");

		if (statusCode == 1)
			ps.setString(1, "Active");
		else
			ps.setString(1, "Restored");

		return ps;
	}

	static PreparedStatement userQueryStmt(Connection conn, int statusCode, String loggedUserName) throws SQLException {

		ps = conn.prepareStatement(
				"Select * from public.incident_data where incident_status = ? and incident_loggedby = ?");

		if (statusCode == 1) {
			ps.setString(1, "Active");
			ps.setString(2, loggedUserName);
		} else if (statusCode == 2) {
			ps.setString(1, "Restored");
			ps.setString(2, loggedUserName);
		}
		return ps;
	}

}
