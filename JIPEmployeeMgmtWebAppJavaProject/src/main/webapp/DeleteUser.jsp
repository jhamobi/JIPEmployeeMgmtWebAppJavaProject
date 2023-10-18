<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Deletion Form</title>
</head>
<body>
	<div class="container">
		<h1 class="text-danger">User Registration Page </h1>
		<form action="UserDeletionServlet" method="post">
			<table style="with: 50%">
				
				<tr>
					<td>UserName for deletion</td>
					<td><input type="text" name="username" /></td>
				</tr>
					</table></br>
				
			<input type="submit" value="Delete User" />
		</form>
	</div>
	</head>


</body>
</html>