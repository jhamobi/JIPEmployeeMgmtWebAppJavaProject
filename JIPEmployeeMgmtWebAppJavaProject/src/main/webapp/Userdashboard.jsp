<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheUserRegistrationServletet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
<div align='center'><h1 class="text-danger" >User Dashboard</h1></div></br>
	<div class="container">
		<h2 class="text-danger">User Registration</h2>
		<form action="UserRegistration.jsp" method="post">
			<button type="submit" class="btn btn-primary">RegisterUser</button>
		</form>
	</div>
	<div class="container">
		<h2 class="text-danger">User Deletion</h2>
		<form action="DeleteUser.jsp" method="post">
			<button type="submit" class="btn btn-primary">Delete User</button>
		</form>
	</div>
	<div class="container">
		<h2 class="text-danger">User Update</h2>
		<form action="UpdateUser.jsp" method="post">
			<button type="submit" class="btn btn-primary">Update User</button>
		</form>
	</div>
	<div class="container">
		<h2 class="text-danger">Load Users Data</h2>
		<form action="LoadUsersDataServlet" method="post">
			<button type="submit" class="btn btn-primary">Upload Users Data</button>
		</form>
	</div>
	</head>


</body>
</html>