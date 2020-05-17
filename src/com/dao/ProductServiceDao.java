package com.dao;

import java.util.List;

import com.dto.Product;

public interface ProductServiceDao {

	public Boolean createProduct(Product product);
	
	public Boolean updateProduct(Product product);
	
	public Product getProduct(int productKey);
	
	public List<Product> getAllProducts();
	
	public Boolean deleteProduct(int productKey);
}
