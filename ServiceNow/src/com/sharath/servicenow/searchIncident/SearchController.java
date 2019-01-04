package com.sharath.servicenow.searchIncident;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String incidentNumber = request.getParameter("incidentNumber");
		int castincidentNumber = Integer.parseInt(incidentNumber);

		IncidentBean inc = new IncidentBean();
		inc.setIncidentNumber(castincidentNumber);

		try {
			IncidentBean finalResultofIncident = SearchService.serviceLayer(inc);
			if(finalResultofIncident.getIncidentReportedUser()!= null){
			request.setAttribute("intAtt", finalResultofIncident);
			request.getRequestDispatcher("/SearchIncidentFile/incidentSearch.jsp").forward(request, response);}
			else{
				request.setAttribute("notIntAtt", finalResultofIncident);
				request.getRequestDispatcher("/SearchIncidentFile/noIncident.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
