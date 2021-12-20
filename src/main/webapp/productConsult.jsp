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
		<form action="findProduct" method="post">
			<div>
				<label><strong>Search by product description: </strong></label>
				<input type="text" name="description">
			</div>
			<br>
			<div>
				<input type="submit" name="save" value="Find Product">
			</div>
		</form>
	</main>
	
</body>
</html>