<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


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
							<li><a href="${contextPath}/categoryItems/${cat.categoryName}">${cat.categoryName}</a></li>
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
		</div>
	</nav>

</div>