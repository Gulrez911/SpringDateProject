<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Home</title>
<link href="./resources/css/bootstrap.css" rel="stylesheet" />

</head>
<body>
	<div class="container">
		<h2>Student Form</h2>
		<a href="/SpringDateProject/list">Student List</a>
		<form:form action="save" method="POST" modelAttribute="student">
			<form:hidden path="id"/>
			<div class="form-group">
				<label for="fname">First Name</label>
				<form:input path="firstName" class="form-control" id="fname" />
			</div>
			<div class="form-group">
				<label for="lname">Last Name</label>
				<form:input path="lastName" class="form-control" id="lname" />
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input path="email" class="form-control" id="email" />
			</div>
			<div class="form-group">
				<label for="pwd">Password</label>
				<form:input path="password" type="password" class="form-control"
					id="pwd" />
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>

		</form:form>

	</div>
</body>
</html>
