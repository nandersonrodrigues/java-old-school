package com.oldschool.dao;

import com.oldschool.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDao {
	
	public void registerProduct (Product product) {
		
		String sql = "insert into product values (null, ?, ?, ?, ?)";
		
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
}
