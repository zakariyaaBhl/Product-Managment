<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<title>Users Page</title>
</head>
<body>
<br>
	<div class="container col-md-6 col-md-offset-3 text-center">
	<ul class="nav nav-tabs">
	  <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
	  <li role="presentation"><a href="${pageContext.request.contextPath}/admin/allUsers">Users</a></li>
	  <li role="presentation"><a href="#">Add User</a></li>
	</ul>
	<br>
		<div class="panel panel-info">
			<div class="panel-heading">
				<h2>Users : </h2>
			</div>
			<div class="panel-body text-center">
					<table class="table table-stripped">
						<tr>
							<th>UserName</th><th></th>
						</tr>
						
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.username}"</td>
								<td></td>
							</tr>
						</c:forEach>
						
					</table>
			</div>
		</div>
	
	</div>
</body>
</html>