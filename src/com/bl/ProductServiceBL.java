package com.bl;

import com.dto.Product;
import com.dto.ResponseDTO;

public interface ProductServiceBL {

	public ResponseDTO createProduct(Product product);
	
	public ResponseDTO updateProduct(Product product);
	
	public ResponseDTO getAllProducts();
	
	public ResponseDTO getProduct(int productKey);
	
	public ResponseDTO deleteProduct(int productKey);
	
}
