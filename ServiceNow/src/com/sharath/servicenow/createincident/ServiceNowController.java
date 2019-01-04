package com.sharath.servicenow.createincident;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

public class ServiceNowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ServiceNowController.class);
	

	public ServiceNowController() {
		super();
	}

	@RequestMapping("/ticket")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logger.debug("doGet Message is called");

		String incidentUser = request.getParameter("incidentUser");
		String contactNumber = request.getParameter("capturecontact");

		long convertContactNumber = Long.parseLong(contactNumber);

		String applicationImpacted = request.getParameter("appImpacted");
		String incidentStatus = request.getParameter("incidentStatus");
		String incidentShortDesciption = request.getParameter("shortDesc");
		String incidentPriority = request.getParameter("priority");

		IncidentBean inc = new IncidentBean();
		inc.setIncidentReportedUser(incidentUser);
		inc.setContactNumber(convertContactNumber);
		inc.setApplicationImpacted(applicationImpacted);
		inc.setIncidentStatus(incidentStatus);
		inc.setShortDesciption(incidentShortDesciption);
		inc.setIncidentPriority(incidentPriority);

		ServiceNowServiceLayer service = new ServiceNowServiceLayer();
		
		logger.debug("Calling service now layer");

		try {
			boolean result = service.serviceLayer(inc);
			if (result == true) {
				String name = inc.getIncidentReportedUser()
						+ " your incident has been created and the incident number is " + inc.getIncidentNumber();
				request.setAttribute("SuccessResults", name);
				request.getRequestDispatcher("/IncidentFiles/incidentcreated.jsp").forward(request, response);

			} else {
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
