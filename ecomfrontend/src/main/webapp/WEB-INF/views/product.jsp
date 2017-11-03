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
<title>Add Products</title>

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>

	<form:form id="productProcess" modelAttribute="product"
		action="productProcess" method="post">


		<div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h2 style="text-align: center;">Add Product</h2>
					<div class="form-group">
						<label for="productName">Product Name</label>
						<form:input type="text" path="productName" class="form-control"
							name="productName" id="productName"
							placeholder="Enter Product Name" required="required" />
					</div>
					<div class="form-group">
						<label for="productDesc">Product Description</label>
						<form:input path="productDesc" type="text" class="form-control"
							name="productDesc" id="productDesc"
							placeholder="Enter product Description" />
					</div>
					<div class="form-group">
						<label for="productPrice">Product Price</label>
						<form:input path="productPrice" type="number" class="form-control"
							name="productPrice" id="productPrice"
							placeholder="Enter product Price" />
					</div>
					<div class="form-group">
						<label for="sel1">Select Category:</label>
						<form:select class="form-control" id="sel1"
							path="category.categoryId">
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.categoryId}">${category.categoryName}</option>
							</c:forEach>
						</form:select>
					</div>

					<button type="submit" class="btn btn-default" value="Save">Submit</button>


				</div>
			</div>
		</div>
	</form:form>

	<div class="container">


		<h2 style="text-align: center;">Product List</h2>

		<table class="table table-bordered">
			<thead>
				<tr style="text-align: center;">
					<th style="text-align: center;">Product Name</th>
					<th style="text-align: center;">Product Description</th>
					<th style="text-align: center;">Product Price</th>
				</tr>
			</thead>
			<c:forEach items="${productList}" var="products">

				<tr style="text-align: center;">
					<td>${products.productName}</td>
					<td>${products.productDesc}</td>
					<td>${products.productPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>