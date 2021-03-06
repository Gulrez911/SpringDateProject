<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Home</title>
<link rel="shortcut icon" type="image/png" href="./resources/image/Fruit-Cherry-icon.png">
<link href="./resources/css/bootstrap.css" rel="stylesheet" />
<script src="./resources/js/jquery.min.js" type="text/javascript"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
	<div class="container">
		<h2>Student Form</h2>
		<a href="/SpringDateProject/list">Student List</a>
		<form:form action="save" method="POST" modelAttribute="student" enctype="multipart/form-data">
			<form:hidden path="id" />
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
				<form:input path="email" class="form-control" id="email"/>
			</div>
			<div class="form-group">
				<label for="pwd">Password</label>
				<form:input path="password" type="password" class="form-control"
					id="pwd" />
			</div>
			<div class="form-group">
				<label for="hobby">Hobby</label>
				<form:select path="hobby" items="${hobbies}" type="hobby"
					class="form-control" id="pwd" />
			</div>

			<div class="form-group">
				<label for="hobby">Upload Document</label>
<%-- 				<form:input path="document" type="file" class="form-control" /> --%>
				<input type="file" name="file" size="50" />
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>

		</form:form>

	</div>
</body>
</html>
