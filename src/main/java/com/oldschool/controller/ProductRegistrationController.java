package com.oldschool.controller;

import java.io.IOException;
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
		
		String description = request.getParameter("description");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		double price = Double.parseDouble(request.getParameter("price"));
		boolean available = false;
		if (request.getParameter("available") != null && 
			request.getParameter("available").equals("on")) available = true;
		
		System.out.println(description);
		System.out.println(quantity);
		System.out.println(price);
		System.out.println(available);
	}
}
