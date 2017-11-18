<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#myModal">My Cart</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog style="width:100px;">
			<!-- <div class="modal-dialog modal-lg"> -->
			
			</div>

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">My Cart</h4>
					</div>
					<div class="modal-body">
						<div class="container">
						<div class="table-responsive">
						
						<table class="table" style="width:100%;">
						
						<tr>
										<th>Product</th>
										<th>Price of Product</th>
										<th>Quantity</th>
										<th>Total Price</th>
										<th>Edit / Delete from Cart</th>
									</tr>
									<c:forEach items="${cartItems}" var="cartItem">

										<tr>
											<td>${cartItem.product.productName}</td>
											<td>${cartItem.product.productPrice}</td>
											<td>${cartItem.cartItemsQuantity}</td>
											<td>${cartItem.cartItemsPrice}</td>
											
											<td><a
												href="${contextPath}/customer/editCartItems/${cartItem.cartItemsId}"><button
														type="button" class="btn btn-primary">Edit Item</button></a>
											

											<a
												href="${contextPath}/customer/deleteCartItems/${cartItem.cartItemsId}"><button
														type="button" class="btn btn-danger">Delete Item</button></a></td>

										</tr>

									</c:forEach>

									<tr>
										<td colspan="3">Total Price of Cart</td>
										<td>${cart.totalPrice}</td>
										<td></td>
									</tr>
									
						
						</table>
						
						</div>

							<div class="table-bordered">
								<table border="2" align="center" class="table table-inverse">
								

									<tr>
										<td>Product</tdh
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

											<td><a
												href="${contextPath}/customer/deletCartItems/${cartItem.cartItemsId}"><button
														type="button" class="btn btn-danger">Delete Item</button></a></td>

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
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

	</div>



</body>
</html> --%>