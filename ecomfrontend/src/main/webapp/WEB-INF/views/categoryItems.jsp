<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html;">
<title>Categories</title>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="image" value="${contextPath}/resources/images" />


	<style>
.img-thumbnail {
	height: 300px;
	width: 400px;
}
</style>
	<div class="container" style="margin-top: 100px;">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="row">
				<c:forEach items="${products}" var="product">
					<div class="col-md-6" style="text-align: center">


						<a"${contextPath}/product/${product.productName}"><img
							src="${image}/${product.productName}.jpg" class="img-thumbnail"></a>
						<h3>Description: ${product.productDesc}</h3>
						<h3>Cost: ${product.productPrice}</h3>

					</div>
				</c:forEach>
			</div>
		</div>
	</div>


</body>
</html>