package com.sharath.servicenow.filterIncidentdata;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Filter() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("user");
		String selectedStatus = request.getParameter("status");
		
		int statusCode = Integer.parseInt(selectedStatus);


		try {
			List<IncidentBean> controllerData = FilterService.serviceFilter(userName, statusCode);
			request.setAttribute("filter", controllerData);
			request.getRequestDispatcher("filterResult.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
