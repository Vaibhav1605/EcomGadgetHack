<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GadgetHack</title>
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
<br>
<br>


	<c:set var="images" value="${contextPath}/resources/images" />
	<c:set var="image" value="${contextPath}/resources/images/" />
	<div class="container">
	
	<div class="table-responsive">
		<table border="2" align="center" class="table table-inverse"
			style="width: 70%">
			
			<tr>
				<td>Product</td>
				<td>Price of Product</td>
				<td>Quantity</td>
				<td>Total Price</td>
				<td>Remove from Cart</td>
			</tr>
			<c:forEach items="${cartItems}" var="cartItem">
			
				<tr>
					<td>${cartItem.product.productName}</td>
					<td>${cartItem.product.productPrice}</td>
					<td>${cartItem.cartItemsQuantity}</td>
					<td>${cartItem.cartItemsPrice}</td>
					
					<td><a href="${contextPath}/customer/deletCartItems/${cartItem.cartItemsId}"><button
								type="button" class="btn btn-danger">Remove</button></a></td>


				</tr>
				
			</c:forEach>
			
				<tr>
				    <td colspan="3">Total Price of Cart</td>
				    <td>${cart.totalPrice}</td>
				    <td></td>
				</tr>
		</table>
	</div>

</div>
</body>
</html>