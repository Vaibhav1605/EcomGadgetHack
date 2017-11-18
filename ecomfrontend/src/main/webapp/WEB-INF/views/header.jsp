<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="images" value="${contextPath}/resources/images" />


<body>
	<div class="header container">
		<nav class="navbar navbar-fixed-top navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">GadgetHack</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="${contextPath}">Home</a></li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="${contextPath}/admin/product">Products</a></li>

						<li><a href="${contextPath}/admin/category">Category</a></li>
					</security:authorize>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Categories<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<c:forEach var="cat" items="${categoryList}">
								<li><a
									href="${contextPath}/categoryItems/${cat.categoryName}">${cat.categoryName}</a></li>
							</c:forEach>
						</ul></li>
				</ul>
				<security:authorize access="isAnonymous()">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${contextPath}/signUp"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="${contextPath}/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</ul>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="${contextPath}/logout"><span
								class="glyphicon glyphicon-user"></span>Logout</a></li>
					</ul>
				</security:authorize>

				<security:authorize access="!hasAuthority('ROLE_ADMIN')">
					<ul class="nav navbar-nav navbar-right">
						<li><button type="button" class="btn btn-info btn-lg"
								data-toggle="modal" data-target="#myModal">My Cart</button></li>
					</ul>
				</security:authorize>


			</div>
		</nav>


		<div class="container">
			<!-- Trigger the modal with a button -->


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

								<table class="table" style="width: 100%;">

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
											<form action="${contextPath}/customer/editCartItem/${cartItem.cartItemsId}" method="POST">
											<td><input type="number" name="Quantity"
												value="${cartItem.cartItemsQuantity}" /></td>
											<td>${cartItem.cartItemsPrice}</td>

											<td><input type="submit" class="btn btn-primary" value="Edit">
												</form> <a
												href="${contextPath}/customer/deleteCartItem/${cartItem.cartItemsId}"><button
														type="button" class="btn btn-danger">Delete Item</button></a>
											</td>

										</tr>

									</c:forEach>

									<tr>
										<td colspan="3">Total Price of Cart</td>
										<td>${cart.totalPrice}</td>
										<td></td>
									</tr>


								</table>

							</div>

							<%-- <div class="table-bordered">
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
 --%>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning" data-dismiss="modal">Buy
							Now</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
					</div>
				</div>

			</div>
		</div>

	</div>

	</div>