<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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


<title>Product Information</title>

<jsp:include page="header.jsp"></jsp:include>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="images" value="${contextPath}/resources/images" />

</head>

<body>
	<div class="container-fluid" style="margin-top: 150px;">
		<c:set var="images"
			value="${pageContext.request.contextPath}/resources/images" />
		<div class="row">
			<div class="col-sm-6">

				<h2>${product.productName }</h2>
				<img src="${images}/${product.productName}.jpg"
					style="height: 300px;" />
			</div>


			<div class="col-sm-6">
				<br>
				<h2>Product Desc: ${product.productDesc}</h2>
				<h2>Product Cost: ${product.productPrice}</h2>
				<%-- <form
					action="${contextPath}/customer/addtocart/${product.productId}"> --%>
				<!-- <input type="number" name="Quantity" placeholder="Select Quantity"> -->
				<a href="${contextPath}/customer/addtocart/${product.productId}"><button
						class="btn btn-primary">Add to Cart</button></a>
				<!-- <button type="button" class="btn btn-primary">Add To Cart</button> -->
				<!-- <button type="button" class="btn btn-warning">Buy Now</button> -->
			</div>
		</div>
	</div>
</body>
</html>