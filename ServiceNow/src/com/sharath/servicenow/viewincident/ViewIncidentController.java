package com.sharath.servicenow.viewincident;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewIncidentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewIncidentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<IncidentBean> incidentData  = IncidentViewService.serviceList();
			//List<IncidentBean> incidentData = IncidentViewService.serviceList();
			
			request.setAttribute("INCIDENTDATA", incidentData);
			request.getRequestDispatcher("/ViewAllIncident/incidentdata.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
