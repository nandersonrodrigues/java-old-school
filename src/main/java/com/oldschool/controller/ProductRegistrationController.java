package com.oldschool.controller;

import java.io.IOException;

import com.oldschool.model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ProductRegistrationController extends jakarta.servlet.http.HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ProductRegistrationController() {
 
    }

	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String description, message;
		Integer quantity;
		Double price;
		boolean available;
		
		if (request.getParameter("description") != null && !request.getParameter("description").isEmpty() && 
			request.getParameter("quantity") != null && !request.getParameter("quantity").isEmpty() &&
			request.getParameter("price") != null && !request.getParameter("price").isEmpty()) {
			
			description = request.getParameter("description");
			quantity = Integer.parseInt(request.getParameter("quantity"));
			price = Double.parseDouble(request.getParameter("price"));
			available = false;
			if (request.getParameter("available") != null && 
				request.getParameter("available").equals("on")) available = true;
			
			Product product = new Product(description, price, available, quantity);
			
			product.save();
			
			message = "Product has been successfully registered !";
		}
		else {
			message = "Fields must be filled !";
		}
		
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productRegistration.jsp");
		dispatcher.forward(request, response);
	}
}
