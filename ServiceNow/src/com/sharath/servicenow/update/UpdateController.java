package com.sharath.servicenow.update;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String incStatus = request.getParameter("status");
		
		
		String incNum = request.getParameter("incidentnumber");
		int castIncidentNumber = Integer.parseInt(incNum);
		
		
		
		IncidentBean inc = new IncidentBean();
		inc.setIncidentStatus(incStatus);
		inc.setIncidentNumber(castIncidentNumber);
		
		
		try {
			boolean result = UpdateService.updateService(inc);
			
			if(result == true){
				request.setAttribute("update", inc);
				request.getRequestDispatcher("updateResult.jsp").forward(request, response);}
			else{
				System.out.println("Not updated");}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
