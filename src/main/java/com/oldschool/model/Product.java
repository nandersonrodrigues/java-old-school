package com.oldschool.model;

public class Product {
	
	private int productId;
	private String description;
	private double price;
	private boolean isAvailable;
	
	public Product () {	}
	
	public Product(String description, double price, boolean isAvailable) {
		super();
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public Product (int productId, String description, double price, boolean isAvailable) {
		this.productId = productId;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
