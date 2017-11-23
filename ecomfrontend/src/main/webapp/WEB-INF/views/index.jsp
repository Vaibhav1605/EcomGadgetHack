
<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<title>GadgetHack</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="carousel_images"
	value="${contextPath}/resources/carousel-images" />
<c:set var="images" value="${contextPath}/resources/images" />


</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>


	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>


			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="${carousel_images}/Gadget Hack.jpg" alt="Gadget Hack"
						style="width: 100%; height: 500px; margin: 0 auto;">
					<div class="carousel-caption">
						<h3>Gadgets</h3>
						<p>Get everyday Gadgets.!</p>
					</div>
				</div>


				<div class="item">
					<img src="${carousel_images}/Shutter.jpg" alt="DSLR"
						style="width: 100%; height: 500px; margin: 0 auto;">
					<div class="carousel-caption">
						<h3>Cameras</h3>
						<p>Click Ultimate Pictures</p>
					</div>
				</div>

				<div class="item">
					<img src="${carousel_images}/VR Lens.jpg" alt="VR Lens"
						style="width: 100%; height: 500px; margin: 0 auto;">
					<div class="carousel-caption">
						<h3>VR Lens</h3>
						<p>Experience Virtual Reality like never before.!</p>
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<div class="container">
		<c:forEach items="${categoryList}" var="cat" begin="0" end="3">
			<h2>${cat.categoryName}</h2>
			<div class="row">
				<c:forEach items="${cat.products}" var="product" begin="0" end="2">
					<div class="col-md-4">
						<div class="img-responsive">
							<a href="${contextPath}/productInfo/${product.productId}.jpg"
								target="_self"> <img
								src="${images}/${product.productName}.jpg" alt="productImage"
								style="width: 150px; height: 150px;"></a>
							<div class="caption">
								<p>${product.productName}</p>
								<p>${product.productDesc}</p>
								<p>${product.productPrice}</p>
								<%-- <a
										href="${contextPath}/customer/addtocart/${product.productId}"><button
											class="btn btn-primary">Add to Cart</button></a> --%>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
		</c:forEach>


	</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>