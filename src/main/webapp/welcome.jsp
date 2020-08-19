<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<%
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("usr") == null) {
		response.sendRedirect("index.jsp");
	}
	%>
	


	<h3>Your Details Information</h3>
	<%
		List<String> details = (ArrayList<String>) request.getAttribute("showUserDetail");
	out.print("<div class=\"formBorder\">");
	for (String detailsIterate : details) {

		out.print(detailsIterate);
		out.print("<br>");

	}
	out.print("</div>");
	%>
	
	


	<div style="text-align: center;">

		<form action="logout">

			<input type="submit" id="button1" value="signout">

		</form>
	</div>

</body>
</html>