package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dto.Product;

import util.DbConnection;

public class ProductServiceDaoImpl implements ProductServiceDao {

	@Override
	public Boolean createProduct(Product product) {
		// TODO Auto-generated method stub
		
		Boolean success = false;		
		DbConnection connection = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		String sqlQuery = "";
		
		try {
			connection = new DbConnection();
			conn = connection.getConnection();
			if(conn.isValid(0)){
				sqlQuery = "INSERT INTO product (productId,productName,productPrice,"
						+ "productExpiryDate,productMfgDate,MfgLocation,"
						+ "isAuthorisedSeller) VALUES(?,?,?,?,?,?,?) ";
				pStatement = conn.prepareStatement(sqlQuery);
				pStatement.setString(1, product.getProductId());
				pStatement.setString(2, product.getProductName());
				pStatement.setDouble(3, product.getProductPrice());
				pStatement.setDate(4, product.getProductExpiryDate());
				pStatement.setDate(5, product.getProductMfgDate());
				pStatement.setString(6, product.getMfgLocation());
				pStatement.setBoolean(7, product.getIsAuthorisedSeller());
				
				int created = pStatement.executeUpdate();
				if(created>0) {
					success = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return success;
	}

	@Override
	public Boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		Boolean success = false;		
		DbConnection connection = null;
		PreparedStatement pStatement = null;
		String sqlQuery = "";
		Connection conn = null;
		
		try {
			connection = new DbConnection();
			conn = connection.getConnection();
			if(conn.isValid(0)){
				sqlQuery = "UPDATE product set productId=?,productName=?,productPrice=?,"
						+ "productExpiryDate=?,productMfgDate=?,MfgLocation=?,"
						+ "isAuthorisedSeller=? WHERE productKey=? ";
				pStatement = conn.prepareStatement(sqlQuery);
				pStatement.setString(1, product.getProductId());
				pStatement.setString(2, product.getProductName());
				pStatement.setDouble(3, product.getProductPrice());
				pStatement.setDate(4, product.getProductExpiryDate());
				pStatement.setDate(5, product.getProductMfgDate());
				pStatement.setString(6, product.getMfgLocation());
				pStatement.setBoolean(7, product.getIsAuthorisedSeller());
				pStatement.setInt(8, product.getProductKey());
				
				int created = pStatement.executeUpdate();
				if(created>0) {
					success = true;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return success;
	}

	@Override
	public Product getProduct(int productKey) {
		// TODO Auto-generated method stub
		
		Product product = null;
		DbConnection connection = null;
		PreparedStatement pStatement = null;
		String sqlQuery = "";
		Connection conn = null;
		
		try {
			connection = new DbConnection();
			conn = connection.getConnection();
			if(conn.isValid(0)){
				sqlQuery = "SELECT * FROM product where productKey=?";
				pStatement = conn.prepareStatement(sqlQuery);
				pStatement.setInt(1, productKey);
				
				ResultSet set = pStatement.executeQuery();
				System.out.println(set.getRow()); 
				while(set.next()) {
					
					
					product = new Product(
							set.getInt(1),
							set.getString(2),
							set.getString(3),
							set.getLong(4),
							set.getDate(5),
							set.getDate(6),
							set.getString(7),
							set.getBoolean(8)
							);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> listProducts = new ArrayList<Product>();	
		Product product = null;
		DbConnection connection = null;
		Statement statement = null;
		String sqlQuery = "";
		Connection conn = null;
		
		try {
			connection = new DbConnection();
			conn = connection.getConnection();
			if(conn.isValid(0)){
				sqlQuery = "SELECT * FROM product";
				statement = conn.createStatement(); 
				ResultSet set = statement.executeQuery(sqlQuery);
				
				while(set.next()) {
					
					
					product = new Product(
							set.getInt(1),
							set.getString(2),
							set.getString(3),
							set.getLong(4),
							set.getDate(5),
							set.getDate(6),
							set.getString(7),
							set.getBoolean(8)
							);
					listProducts.add(product);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listProducts;
	}

	@Override
	public Boolean deleteProduct(int productKey) {
		// TODO Auto-generated method stub
		
		Product product = null;
		DbConnection connection = null;
		PreparedStatement pStatement = null;
		String sqlQuery = "";
		Connection conn = null;
		Boolean deleted = false;
		
		try {
			connection = new DbConnection();
			conn = connection.getConnection();
			
			if(conn.isValid(0)) {
				
				sqlQuery = "DELETE FROM product WHERE productKey=?";
				pStatement = conn.prepareStatement(sqlQuery);
				pStatement.setInt(1, productKey);
				deleted = pStatement.execute(); 
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return deleted;
	}

}
