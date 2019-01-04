<%@page import="com.sharath.servicenow.viewincident.IncidentBean"%>
<%@page
	import="com.sharath.servicenow.viewincident.ViewIncidentController"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incident Data</title>
</head>
<body>

<h2 style="color: red"> List of Incident created </h2>
	<table border="1">
		<thead>
			<tr>
				<th>Incident Number</th>
				<th>Reported User</th>
				<th>Contact Number</th>
				<th>Application Impacted</th>
				<th>Incident Status</th>
				<th>Incident short description</th>
				<th>Incident priority</th>
				
			</tr>
		</thead>

		
		<tbody>
		<%
			List<IncidentBean> data = (List<IncidentBean>) request.getAttribute("INCIDENTDATA");
			for (IncidentBean inc : data) {
		%>
			<tr>
				<td><%=inc.getIncidentNumber()%></td>
				<td><%=inc.getIncidentReportedUser()%></td>
				<td><%= inc.getContactNumber() %></td>
				<td><%=inc.getApplicationImpacted()%></td>
				<td><%=inc.getIncidentStatus()%></td>
				<td><%=inc.getShortDesciption()%></td>
				<td><%=inc.getIncidentPriority()%></td>
			</tr>
			<%
		}
	%>

		</tbody>
	</table>
	
	


</body>
</html>