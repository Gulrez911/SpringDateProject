<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<title>Student Home</title>
<link href="./resources/css/bootstrap.css" rel="stylesheet" />

</head>
<body>
	<div class="container">
		<h2>Student List</h2>
		<a href="/SpringDateProject">Add New Student</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th align="center">Action</th>
					<!-- 					<th></th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="li">
					<tr>
						<td>${li.firstName}</td>
						<td>${li.lastName}</td>
						<td>${li.email}</td>
						<td><a href="update?id=${li.id}" ><button class="btn btn-primary">Edit</button></a>&nbsp&nbsp
							<a href="delete?id=${li.id}" ><button class="btn btn-danger">Delete</button></a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>


	</div>
</body>
</html>
