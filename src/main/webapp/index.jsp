<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Please Login !</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>


	<h3>
		<a href="register.jsp" style="color: black; text-decoration: none;">Register
			Page</a><span style="margin: 0px 20px;">|</span> <a
			style="border: 2px solid white; box-shadow: 0px 0px 3px 1.5px white; padding: 2px; background-color: white; border-radius: 8px;">Login
			Page</a>
	</h3>

	<div class="formBorder">

		<form action="login" method="post">
			<input type="text" name="uname" placeholder="Enter MailID" id="field" required><br />
			<br /> <input type="password" name="pwd"
				placeholder="Enter password" id="field" required><br /> <br /> <input
				type="submit" id="button" value="Login">


		</form>
	</div>

</body>
</html>