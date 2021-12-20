package com.oldschool.model;

import java.util.ArrayList;

import com.oldschool.dao.ProductDao;

public class Product {
	
	private Integer productId;
	private String description;
	private Double price;
	private boolean isAvailable;
	private Integer quantity;
	
	public Product () {	}
	
	public Product(String description, Double price, boolean isAvailable, Integer quantity) {
		super();
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.quantity = quantity;
	}

	public Product (Integer productId, String description, Double price, boolean isAvailable) {
		this.productId = productId;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public Integer getProductId() {
		return productId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}	

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	} 
	
	public void save() {
		new ProductDao().registerProduct(this);
	}
	
	public ArrayList<Product> findProductByDescription (String description) {
		return new ProductDao().findProductsByDescription(description);
	}
}
