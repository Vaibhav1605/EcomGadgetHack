<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
p {
	margin: 10px;
	color: white;
}

h4 {
	color: white;
}

.fa {
	padding: 10px;
	font-size: 20px;
	text-decoration: none;
	text-align: center;
	margin: 5px 5px;
}

.fa:hover {
	opacity: 0.7;
}

.fa-facebook {
	background: #3B5998;
	color: white;
}

.fa-twitter {
	background: #55ACEE;
	color: white;
}

.fa-google {
	background: #dd4b39;
	color: white;
}

.fa-linkedin {
	background: #007bb5;
	color: white;
}
</style>

	<nav class="nav navbar-inverse" style="margin-top: 115px">
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-4 column">
				<ul style="list-style-type: none">
					<li style="margin-top: 20px; text-align: justify"><h4>About
							Us</h4></li>
					<li style="color: white">Gadget Hack is a place where you get
						all your daily using gadgets as well as their Accessories.</li>
				</ul>
			</div>
			<div class="col-sm-4 column">
				<div class="navigation">
					<ul class="bottommenu" style="list-style-type: none">
						<li></li>
						<li></li>
						<li><p>Contact Us</p>
							<p>
								<span class="glyphicon glyphicon-envelope"></span> Email Us:
								info@gadgethack.com
							</p>
							<p>
								<span class="glyphicon glyphicon-earphone"></span>Toll Free :
								1800555666
							</p></li>

					</ul>

				</div>
			</div>
			<div class="col-sm-4 column">
				<div>
					<p>
						<b style="color: white"> Follow Us On</b>
					</p>
				</div>
				<div>
					<a href="#" class="fa fa-facebook"></a> <a href="#"
						class="fa fa-twitter"></a> <a href="#" class="fa fa-google"></a> 
				</div>
			</div>

		</div>

		<div class="row">

			<h4 style="text-align: center; color: white">
				copyright&copy;2017 <b style="color: white">Gadget Hack</b>
			</h4>
		</div>
	</div>
	</nav>
</body>
</html>