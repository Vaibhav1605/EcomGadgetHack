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
<title>Add Category</title>

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>

	<form:form id="categoryProcess" modelAttribute="category"
		action="${pageContext.request.contextPath}/admin/categoryProcess"
		method="post">


		<div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h2 style="text-align: center;">Add Category</h2>
					<form:input type="hidden" path="categoryId" />
					<div class="form-group">
						<label for="categoryName">Category Name</label>
						<form:input type="text" path="categoryName" class="form-control"
							name="categoryName" id="categoryName"
							placeholder="Enter Category Name" required="required" />
					</div>
					<div class="form-group">
						<label for="categoryDesc">Category Description</label>
						<form:input path="categoryDesc" type="text" class="form-control"
							name="categoryDesc" id="categoryDesc"
							placeholder="Enter Category Description" required="required" />
					</div>
					<input type="submit" class="btn btn-default" value="Save">

				</div>

			</div>
		</div>
	</form:form>

	<div class="container">


		<h2 style="text-align: center;">Category List</h2>

		<table class="table table-bordered">
			<thead>
				<tr style="text-align: center;">
					<th style="text-align: center;">Category Name</th>
					<th style="text-align: center;">Category Description</th>
					<th style="text-align: center;">Edit / Delete</th>


				</tr>
			</thead>
			<c:forEach items="${categoryList}" var="category">

				<tr style="text-align: center;">
					<td><a href="category/${category.categoryId}">${category.categoryName}</a></td>
					<td>${category.categoryDesc}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/editCategory/${category.categoryId}"><button
								type="button" class="btn btn-warning">Edit</button></a> <a
						href="${pageContext.request.contextPath}/admin/deleteCategory/${category.categoryId}"><button
								type="button" class="btn btn-danger">Delete</button></a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>