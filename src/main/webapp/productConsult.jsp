<%@page import="java.util.List" %>
<%@page import="com.oldschool.model.Product" %>
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
		<%
		if (request.getAttribute("products") != null) {
			List<?> products = (List<?>) request.getAttribute("products");
			for (int i = 1; i < products.size(); i++) {
				Product product = (Product) products.get(i);
		%>
			<div>
				<div class="item">
					<div class="column"> 
						Id <%out.println(product.getProductId()); %>
					</div>
					<div class="column"> 
						Description <%out.println(product.getDescription()); %>
					</div>
					<div class="column"> 
						Quantity <%out.println(product.getQuantity()); %>
					</div>
					<div class="column"> 
						Price <%out.println(product.getPrice()); %>
					</div>
					<div class="column"> 
						Available <%out.println(product.isAvailable() ? "Yes" : "No"); %>
					</div>
					<div>
						<input type="submit" name="edit" value="Edit">
						<input type="submit" name="delete" value="Delete">
					</div>
				</div>
			</div>
		<% 
			}
		} 
		%>
	</main>
	
</body>
</html>