<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Home</title>
<link href="./resources/css/bootstrap.css" rel="stylesheet" />
<link href="./resources/css/style.css" rel="stylesheet" />
<script src="./resources/js/bootstrap.js" type="text/javascript"></script>
<script src="./resources/js/bootstrap.bundle.min.js"
	type="text/javascript"></script>
<script src="./resources/js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Sign In</h5>

						<form:form class="form-signin" modelAttribute="student"
							method="post" action="authenticate">
							<div class="form-label-group">
								<%--               <form:input path="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus/> --%>
								<form:input path="email" id="inputEmail" class="form-control" />
								<label for="inputEmail">Email address</label>
							</div>

							<div class="form-label-group">
									<form:input path="password" type="password" class="form-control" /> <label
									for="inputPassword">Password</label>
							</div>

							<div class="custom-control custom-checkbox mb-3">
								<input type="checkbox" class="custom-control-input"
									id="customCheck1"> <label class="custom-control-label"
									for="customCheck1">Remember password</label>
							</div>
							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Sign in</button>
							<hr class="my-4">
							<button class="btn btn-lg btn-google btn-block text-uppercase"
								type="submit">
								<i class="fab fa-google mr-2"></i> Sign in with Google
							</button>
							<button class="btn btn-lg btn-facebook btn-block text-uppercase"
								type="submit">
								<i class="fab fa-facebook-f mr-2"></i> Sign in with Facebook
							</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
