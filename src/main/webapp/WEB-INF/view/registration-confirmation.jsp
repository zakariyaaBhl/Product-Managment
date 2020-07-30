<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Registration Confirmation</title>
</head>
<body>
	<div class="container col-md-6 col-md-offset-3 text-center">
		<div class="panel panel-success">
			<div class="panel-heading">Confirmation Page</div>
			<div class="panel-body">
				<h2>User registered successfully!</h2>
				<hr>
				<a href="${pageContext.request.contextPath}/" class="btn btn-success btn-block">Login with new user</a>
			</div>
		</div>
	</div>
</body>
</html>