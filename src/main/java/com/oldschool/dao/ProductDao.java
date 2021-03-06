package com.oldschool.dao;

import com.oldschool.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
	
	public void registerProduct (Product product) {
		
		String sql = "INSERT INTO product VALUES (null, ?, ?, ?, ?)";
		
		PreparedStatement preparedStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, product.getDescription());
			preparedStatement.setInt(2, product.getQuantity());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setBoolean(4, product.isAvailable());
			preparedStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) preparedStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
	}
	
	public ArrayList<Product> findProductsByDescription (String description) {
		String sql = "SELECT * FROM product WHERE description LIKE '%"+ description+"%'";
		ResultSet resultSet = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		Product product = null;
		ArrayList<Product> products = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet != null) {
				products = new ArrayList<Product>();
				
				while (resultSet.next()) {
					product = new Product();
					product.setProductId(resultSet.getInt("idProduct"));
					product.setDescription(resultSet.getString("description"));
					product.setPrice(resultSet.getDouble("price"));
					product.setQuantity(resultSet.getInt("quantity"));
					product.setAvailable(resultSet.getBoolean("available"));;
					
					products.add(product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) preparedStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
		
		return products;
	}
	
	
}
