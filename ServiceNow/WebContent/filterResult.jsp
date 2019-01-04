<%@page import="com.sharath.servicenow.filterIncidentdata.IncidentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Filter Result</title>

</head>
<body>

<% IncidentBean bean = (IncidentBean) request.getAttribute("filter"); %>

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


</table>

<tbody>
</body>
</html>