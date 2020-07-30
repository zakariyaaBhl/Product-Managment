<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<meta charset="utf-8">
<title>New Product</title>
</head>
<body>
	<br>
	<div class="container col-md-10 col-md-offset-1">
	
		<!-- Static navbar -->
     <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Show Room</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
              
              
              <li class="dropdown">
			    <a href="${pageContext.request.contextPath}/showProd" class=" dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Products
			    <span class="caret"></span></a>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    	
				      <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/showProd">All Products</a></li>
				      <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/addFormProd">Add new Product</a></li>
			      	
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">CSS</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">JavaScript</a></li>
			      <li role="presentation" class="divider"></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">About Us</a></li>
			    </ul>
			  </li>
			  
			  <li class="dropdown">
			    <a href="${pageContext.request.contextPath}/show" class=" dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Categories
			    <span class="caret"></span></a>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    	
				      <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/showCat">All Categories</a></li>
				      <li role="presentation"><a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/addFormCat">Add new Category</a></li>
			      		
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">CSS</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">JavaScript</a></li>
			      <li role="presentation" class="divider"></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">About Us</a></li>
			    </ul>
			  </li>
              
              <li><a href="${pageContext.request.contextPath}/about">About</a></li>
              <li><a href="${pageContext.request.contextPath}/contact">Contact</a></li>
        
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
            	<form:form cssClass="navbar-form navbar-right" action="${pageContext.request.contextPath}/search" method="POST">
				    <div class="form-group">
				        <input type="text" class="form-control" name="motCle" value="${motCle}">
				    </div>
				    <button type="submit" class="btn btn-default">
				        <span class="glyphicon glyphicon-search"></span>
				    </button>
				</form:form>              
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
              <li class="active">
	             	<form:form method="POST" action="${pageContext.request.contextPath}/logout">
	              		<input type="submit" value="Sign Out" class="btn btn-link" style="margin-top: 8px;"><span class="sr-only">(current)</span>
	              	</form:form>
	          </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
	

		<div class="panel panel-info col-md-8 col-md-offset-2">
		<br>
			<div class="panel-heading"><h3 class="text-center">Products</h3></div>
			<div class="panel-body">
				
					<form:form method="POST" action="${pageContext.request.contextPath}/updateProduct" cssClass="text-center" modelAttribute="prod">
					  <div class="form-group text-center">
					    <label for="id">ID : </label>
					    <input type="text" class="form-control text-center" id="id" name="id" value="${product.id}" readonly="readonly">
					  </div>
					  
					  <div class="form-group text-center">
					    <label for="designation">Désignation : </label>
					    <form:errors path="designation" cssClass="error text-danger" />
					    <input type="text" class="form-control text-center" id="designation" name="designation" value="${product.designation}">
					  </div>
					  
					  <div class="form-group text-center">
					    <label for="prix">Prix : </label>
					    <form:errors path="prix" cssClass="error text-danger" />
					    <input type="text" class="form-control text-center" id="prix" name="prix" value="${product.prix}">
					  </div>
					  
					  <div class="form-group text-center">
					    <label for="quantite">Quantité : </label>
					    <form:errors path="quantite" cssClass="error text-danger" />
					    <input type="text" class="form-control text-center" id="quantite" name="quantite" value="${product.quantite}">
					  </div>
					
					  <div class=" form-group text-right">
					  	 <button type="submit" class="btn btn-success btn-block" style="width: 50%;margin: 0 auto;">Update</button>
						 <a type="submit" class="btn btn-link btn-block"  href="${pageContext.request.contextPath}/showProd">Cancel</a>
					  	 
					  </div>
					</form:form>

			</div>
		</div>
	</div>
</body>
</html>