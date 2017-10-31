<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>  
    <%@ page language="java" contentType="text/html;" %>
        <html>
        <head>
        <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
            <meta http-equiv="Content-Type" content="text/html;">
            <title>Add Products</title>
 
        </head>
        <body>

<jsp:include page="header.jsp"></jsp:include>
<br>
<br>

            <form:form id="productProcess" modelAttribute="product" action="productProcess" method="post">
               
                    
                   <div class="container">
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<h2 style="text-align: center;">Add Product</h2>
					<div class="form-group">
						<label for="productName">Product Name:</label> <input type="text"
							class="form-control" id="productName" placeholder="Enter name of the Product"
							name="productName" required="required">
					</div>
					<div class="form-group">
						<label for="productDesc">Product Description:</label> <input type="text"
							class="form-control" id="productDesc" placeholder="Enter Product Description"
							name="productDesc" required="required">
					</div>

					<div class="form-group">
						<label for="productPrice">Product Price:</label> <input
							type="number" class="form-control" id="productPrice"
							placeholder="Enter Product Price" name="productPrice" required="required">
					</div>
					
					<button type="submit" class="btn btn-default" value="Save">Submit</button>
				

				</div>
			</div>
		</div>
            </form:form>
            
          <div class="container">
          
				
  <h2 style="text-align: center;">Product List</h2>
            
  <table class="table table-bordered">
    <thead >
      <tr style="text-align: center;">
        <th style="text-align: center;">Product Name</th>
        <th style="text-align: center;">Product Description</th>
        <th style="text-align: center;">Product Price</th>
      </tr>
    </thead>
			<c:forEach items = "${productlist}" var="products">
			
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