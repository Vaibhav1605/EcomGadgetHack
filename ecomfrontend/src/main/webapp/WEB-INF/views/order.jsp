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
	<div class="container">
		<h1 style="text-align: center;">Invoice</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Quantity</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders.orderedItems}" var="orderItem">
					<tr>
						<td>${orderItem.product.productName}</td>
						<td>${orderItem.product.productPrice}</td>
						<td>${orderItem.orderedItemsTotalQuantity}</td>
						<td>${orderItem.orderedItemsTotalPrice}</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td>Total Price</td>
					<td>${orders.orderTotalPrice}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<center>
		<h2>Thank You For Shopping.!</h2>
	</center>
	<a href="${pageContext.request.contextPath}/">
		<center>
			<button type="button" class="btn btn-primary">Continue
				Shopping</button>
		</center>
	</a>
</body>
</html>