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
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<c:set var="images" value="${contextPath}/resources/images" />

	<div class="container">

		<div class="table-responsive">
			<table border="2" align="center" class="table table-inverse"
				style="width: 70%">
				<thead>
				<tbody>
					<tr>
						<th>Product</th>
						<th>Product Price</th>
						<th>Product Quantity</th>
						<th>Amount</th>

					</tr>
				</thead>
				<c:forEach items="${cartItems}" var="cartItem">
					<tr>
						<td>${cartItem.product.productName}</td>
						<td>${cartItem.product.productPrice}</td>
						<td>${cartItem.cartItemsQuantity}</td>
						<td>${cartItem.cartItemsPrice}</td>
					</tr>

				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td>Total Price</td>
					<td>${cart.totalPrice}</td>
				</tbody>
			</table>

			<center>

				<a href="${contextPath}/">
					<button type="button" class="btn btn-danger">Cancel</button>
				</a> <a href="${contextPath}/customer/address/${cart.cartId}">
					<button type="button" class="btn btn-primary">Confirm
						Order</button>
				</a>
			</center>
		</div>

	</div>

</body>
</html>