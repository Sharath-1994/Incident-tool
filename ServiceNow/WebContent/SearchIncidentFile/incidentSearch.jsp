<%@page import="com.sharath.servicenow.searchIncident.IncidentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Incident</title>
</head>
<body>

<form action="update" method="get">

<h2>Below is your Incident</h2>
<%IncidentBean inc = (IncidentBean) request.getAttribute("intAtt"); %>


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


	<tr>
	
	 <input type = "hidden" name = "incidentnumber"  value = "<%=inc.getIncidentNumber() %>"> 
	<td><%=inc.getIncidentNumber() %></td>
	<td><%=inc.getIncidentReportedUser()  %></td>
	<td><%=inc.getContactNumber() %></td>
	<td><%=inc.getApplicationImpacted()  %></td>
	
	
	
	 <td> <select  name = "status">  <option>  <%=inc.getIncidentStatus()   %> </option>
	 <option value = "Active"> Active </option>
	 <option value="Restored" > Restored </option>
	 <option value = "Re-open" > Re-open</option>
	  </select></td>
	  
	
	<td><%=inc.getShortDesciption()  %></td>
	<td><%=inc.getIncidentPriority()  %></td>
	</tr>
</tbody>


</table>

<br>

	<button> Update incident</button>
	
	<h2><a href="index.html"> click here to return to main page </a></h2>
	
	
	
	 </form>
</body>
</html>