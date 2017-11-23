<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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

<meta http-equiv="Content-Type" content="text/html;">
<title>GadgetHack</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<br>
	<br>

	<form:form method="post" modelAttribute="address"
		action="${contextPath}/customer/addressProcess/">
		<br>
		<br>
		<div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h2>Shipping Address</h2>
					<div class="form-group">
						<form:input path="add_Id" hidden="true" />
						<label for="add_Hno">House No.:</label>
						<form:input type="number" path="add_Hno" class="form-control"
							id="add_Hno" placeholder="Enter House No" name="add_Hno"
							required="required" />
						<form:errors path="add_Hno" style="color:red" />
					</div>
					<div class="form-group">
						<label for="add_Street">Street:</label>
						<form:input type="text" path="add_Street" class="form-control"
							id="add_Street" placeholder="Enter Street" name="add_Street"
							required="required" />
						<form:errors path="add_Street" style="color:red" />
					</div>

					<div class="form-group">
						<label for="add_City">City:</label>
						<form:input type="text" path="add_City" class="form-control"
							id="add_City" placeholder="Your City Name" name="add_City" />
						<form:errors path="add_City" style="color:red" />
					</div>
					<div class="form-group">
						<label for="add_State">State:</label>
						<form:input type="add_State" path="add_State" class="form-control"
							id="add_State" placeholder="Your State" name="add_State"
							required="required" />
						<form:errors path="add_State" style="color:red" />
					</div>
					<div class="form-group">
						<label for="add_Pincode">Pincode:</label>
						<form:input type="add_Pincode" path="add_Pincode"
							class="form-control" id="add_Pincode" placeholder="Enter Pincode"
							name="add_Pincode" required="required" />
						<form:errors path="add_Pincode" style="color:red" />
					</div>

					<button type="submit" class="btn btn-default" value="Save">Submit</button>
				</div>

			</div>
		</div>
	</form:form>

</body>
</html>