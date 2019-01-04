<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incident result Page</title>
</head>
<body>

<h2> <% out.print(request.getAttribute("SuccessResults")); %> </h2> <br><br>


<h2> <a href="createincident.html"> <strong>Click here to create another incident</strong></a></h2>

<h2> <a href = "index.html"> <strong>Click here for main page</strong> </a></h2>

</body>
</html>