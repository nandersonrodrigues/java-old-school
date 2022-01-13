package com.oldschool.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.oldschool.model.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindProductController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String description = request.getParameter("description");
		ArrayList<Product> products = new Product().findProductByDescription(description);
		
		request.setAttribute("products", products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("productConsult.jsp");
		dispatcher.forward(request, response);
	}

}
