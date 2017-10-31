<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html;"%>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>GadgetHack.in</title>
<body>
	<jsp:include page="header.jsp"></jsp:include>
</head>

<body>

	<form:form method="post" modelAttribute="customer"
		action="signUpProcess">
		<br>
		<br>
		<div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h2>SignUp Form</h2>
					<div class="form-group">
						<label for="firstName">First Name:</label> <input type="text"
							class="form-control" id="firstName" placeholder="Enter name"
							name="firstName" required="required">
					</div>
					<div class="form-group">
						<label for="lastName">Last Name:</label> <input type="text"
							class="form-control" id="lastName" placeholder="Enter last name"
							name="lastName" required="required">
					</div>

					<div class="form-group">
						<label for="mobileNumber">Mobile Number:</label> <input
							type="number" class="form-control" id="mobileNumber"
							placeholder="Enter Your Mobile Number" name="mobileNumber">
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" placeholder="Enter your Email Id"
							name="email" required="required">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password"
							placeholder="Atleast 8 Charecters" name="password" required="required">
					</div>
					<div class="form-group">
						<label for="confirmPassword">Confirm Password:</label> <input
							type="password" class="form-control" id="confirmPassword"
							placeholder="Retype password" name="confirmPassword" required="required">
					</div>
					<div class="checkbox">
						<label><input type="checkbox" name="I Agree T&C" required="required">I
							Agree all the T&C*.</label>
					</div>
					<button type="submit" class="btn btn-default" value="Save">Submit</button>

				</div>
			</div>
		</div>
	</form:form>
</body>
</body>
</html>