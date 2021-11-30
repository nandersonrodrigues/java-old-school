<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
	<nav>
		<ul>
			<li>Products</li>
			<li><img src="img/image.png" height="200px"></li>
			<li><a href="productRegistration">Register Product</a></li>
			<li><a href="productConsult">Consult Product</a></li>
		</ul>
	</nav>
	<main>
		<form action="registerProduct" method="post">
		
			<div>
				<label>Description: </label>
				<input type="text" name="description">
			</div>
			<div>
				<label>Quantity: </label>
				<input type="text" name="quantity">
			</div>
			<div>
				<label>Price: </label>
				<input type="text" name="price">
			</div>		
			<div>
				<label>Available: </label>
				<input type="checkbox" name="available" value="on">
			</div>
			
			<div>
				<input id="button" type="submit" name="submit" value="Register Product">
			</div>	
		
		</form>
	</main>
	
</body>
</html>