<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">

				<h2>Login</h2>
				<form action="" method="post">
					<div class="form-group">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" placeholder="Registered Email Id"
							name="username" required="required">
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password" placeholder="Enter password"
							name="password" required="required">
					</div>
					<div class="checkbox">
						<label><input type="checkbox" name="remember">
							Remember me</label>
					</div>
					<input type="submit" value="login" />

				</form>
				<p align="center">
					Don`t have an Account? <a
						href="${pageContext.request.contextPath}/signUp">Create One.!
					</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>