<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="images" value="${contextPath}/resources/images" />


<body>
	<nav class="navbar navbar-fixed-top navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">GadgetHack</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index">Home</a></li>
				<li><a href="product">Products</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Categories<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">DSLR</a></li>
						<li><a href="#">Laptop</a></li>
						<li><a href="#">Mobile</a></li>

					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="signUp"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>
