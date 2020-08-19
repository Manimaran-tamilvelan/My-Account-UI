<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<%
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	%>



	<h3>Users Information</h3>
	<%
		Map<Integer, List<String>> details = (Map<Integer, List<String>>) request.getAttribute("allUsers");
	out.print("<div class=\"formBorderForAll\">");

	out.print("<b>  UserID  | UserName | Password | Mail ID | User DOB | Mobile No </b><br>");
	out.print("------------------------------------------------------------------------------------------------<br>");
	for (Map.Entry<Integer, List<String>> entry : details.entrySet()) {
		
		out.print("&nbsp;&nbsp;" + entry.getKey() + "&nbsp;&nbsp;|&nbsp;");

		for (int loop = 0; loop < entry.getValue().size(); loop++) {
			/**String s0 = entry.getValue().get(loop);
			int forAll = 20;
			int stringLength = s0.length();

			if (loop == 2) {
		        forAll = 30;
			}
			int spaceCount = forAll - stringLength;
			if (stringLength % 2 != 0) {
         		out.print("&nbsp;");
			}
			for (int spacingIter = 1; spacingIter <= spaceCount / 2; spacingIter++) {

		        out.print("&nbsp;");
			}*/
			out.print(entry.getValue().get(loop));
			//for (int spacingIter = 1; spacingIter <= spaceCount / 2; spacingIter++) {
		    //     out.print("&nbsp;");
			//}
			if(loop!=4){
				out.print("&nbsp;|&nbsp;");
			}
		}

		out.println("<br>");

	}

	out.print("</div>");
	%>




	<div style="text-align: center;">

		<form action="logout">

			<input type="submit" id="button1" value="signout">

		</form>
		
		<!-- hello-->
		<div style="padding:20px;">
		<form action="delete">
		
		<input type="number" id="field" placeholder="Enter UserID" name="userID" required>
		<input type="submit" id = "button" value="Delete">
		
		</form></div> 
		
	</div>

</body>
</html>