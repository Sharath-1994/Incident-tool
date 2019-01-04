<%@page import="com.sharath.servicenow.update.IncidentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>

<h2>Update page</h2>

<% IncidentBean inc = (IncidentBean) request.getAttribute("update"); %>

	<h2> Status updated to <%=inc.getIncidentStatus() %> for incident number <%=inc.getIncidentNumber() %></h2>
	
	
	<a href = "searchincident.html"> Click here to search for more incident</a><br> <br>
	
	<a href = "index.html" >Click here for main page </a> 
	
	
</body>
</html>