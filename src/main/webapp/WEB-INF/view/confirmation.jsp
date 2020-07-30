<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<meta charset="utf-8">
<title>Confirmation</title>
</head>
<body>
<br><br><br>
	<div class="container">
		<div class="panel panel-info col-md-8 col-md-offset-2">
		<br>
			<div class="panel-heading"><h3 class="text-center">Confirmation</h3></div>
			<div class="panel-body">
				
					  <div class="form-group text-center">
					    <label for="id">ID : </label>
					    <input type="text" class="form-control text-center" id="id" name="id" value="${product.id}" readonly="readonly">
					  </div>
					
					  <div class="form-group text-center">
					    <label for="designation">Désignation : </label>
					    <input type="text" class="form-control text-center" id="designation" name="designation" value="${product.designation}" readonly="readonly">
					  </div>
					  
					  <div class="form-group text-center">
					    <label for="prix">Prix : </label>
					    <input type="text" class="form-control text-center" id="prix" name="prix" value="${product.prix}" readonly="readonly">
					  </div>
					  
					  <div class="form-group text-center">
					    <label for="quantite">Quantité : </label>
					    <input type="text" class="form-control text-center" id="quantite" name="quantite" value="${product.quantite}" readonly="readonly">
					  </div>
					
					  <div class=" form-group text-right">
					  	 <a type="submit" class="btn btn-success btn-block" style="width: 50%;margin: 0 auto;" 
					  	 href="${pageContext.request.contextPath}/deleteProd?id=${prod.id}" >Cancel The Operation</a>
						 <a type="submit" class="btn btn-link btn-block"  href="${pageContext.request.contextPath}/showProd">Return</a>
					  	 
					  </div>
			</div>
		</div>
	</div>
</body>
</html>