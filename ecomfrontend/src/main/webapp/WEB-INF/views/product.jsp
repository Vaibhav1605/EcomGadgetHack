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
            
            
            <style type="text/css">
            table, th, td {
            border:2px solid black;
            
            }
            </style>
        </head>
        <body>

<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<br>
<br>


            <form:form id="productProcess" modelAttribute="product" action="productProcess" method="post">
                <table align="center" class="table" style = "width:60%">
                    
                    <tr>
                        <td>
                            <form:label path="productName">Product Name</form:label>
                        </td>
                        <td>
                            <form:input path="productName" name="productName" id="productName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="productDesc">Product Description</form:label>
                        </td>
                        <td>
                            <form:input path="productDesc" name="productDesc" id="productDesc" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="productPrice">Product Price</form:label>
                        </td>
                        <td>
                            <form:input path="productPrice" name="productPrice" id="productPrice" />
                        </td>
                    </tr>
                     </table>
                     
                   
                      <form:button id="product" name="addProduct" style="text-align:center;">Add product</form:button>
                        
                    
                
            </form:form>
            
           <table align="center" class="table table-inverse" style = "width:80%">
            
       		<tr>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Price</th>
			</tr>
			<c:forEach items = "${productlist}" var="products">
			
			<tr>
			<td>${products.productName}</td>
			<td>${products.productDesc}</td>
			<td>${products.productPrice}</td>
			</tr>
			</c:forEach>
			</table>
			
        </body>
        </html>