<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Register Page</title>
</head>
<body>
<br>
	<div class="container col-md-4 col-md-offset-4 text-center">
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Register New User</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">
				
					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/processRegistrationForm" modelAttribute="crmUser" class="form-horizontal">
						
						<!-- Check for registration error -->
							<div class="form-group">
					        	<div class="col-xs-15">
					        		<c:if test="${registrationError != null}">
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											${registrationError}
										</div>
									</c:if>
					        	</div>
					        </div>
							
							
						<!-- User name -->
						<form:errors path="userName" cssClass="text-danger" />
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							
							<form:input path="userName" placeholder="username (*)" class="form-control" />
						</div>

						<!-- Password -->
						<form:errors path="password" cssClass="text-danger" />
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
							
							<form:password path="password" placeholder="password (*)" class="form-control" />
						</div>
						
						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-info btn-block">Register</button>
							</div>
							<div class="col-sm-6 controls">
								<a type="submit" class="btn btn-info btn-block" href="${pageContext.request.contextPath}/">Cancel</a>
							</div>
						</div>
						
					</form:form>
				
				</div>
				
			</div>
		</div>
	
	
	
	
	
	
	<div class="container col-md-6 col-md-offset-3">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="text-center">Register New User</h3>
			</div>
			<div class="panel-body">
				<form:form action="${pageContext.request.contextPath}/processRegistrationForm" modelAttribute="crmUser" method="POST">
					
				</form:form>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>