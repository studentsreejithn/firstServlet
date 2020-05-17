package com.bl;

import java.util.List;

import com.dao.ProductServiceDaoImpl;
import com.dto.Product;
import com.dto.ResponseDTO;

public class ProductServiceBLImpl implements ProductServiceBL {

	@Override
	public ResponseDTO createProduct(Product product) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = null;
		responseDTO = new ResponseDTO();
		
		ProductServiceDaoImpl pDaoImpl = null;
		pDaoImpl = new ProductServiceDaoImpl();
		
		Boolean created = pDaoImpl.createProduct(product);
		
		if(created) { 
			responseDTO.setDataClass(product.toString());
			responseDTO.setResponseCode(1);
			responseDTO.setResponseDescription("Added new product");
		} else {
			responseDTO.setDataClass(product.toString());
			responseDTO.setResponseCode(0);
			responseDTO.setResponseDescription("Unable to add a new product");
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO updateProduct(Product product) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = null;
		responseDTO = new ResponseDTO();
		
		ProductServiceDaoImpl pDaoImpl = null;
		pDaoImpl = new ProductServiceDaoImpl();
		
		Boolean created = pDaoImpl.updateProduct(product);
		
		if(created) { 
			responseDTO.setDataClass(product.toString());
			responseDTO.setResponseCode(1);
			responseDTO.setResponseDescription("updated new product");
		} else {
			responseDTO.setDataClass(product.toString());
			responseDTO.setResponseCode(0);
			responseDTO.setResponseDescription("Unable to update the product");
		}
		return responseDTO;
	}

	@Override
	public ResponseDTO getAllProducts() {
		// TODO Auto-generated method stub
		
		ResponseDTO responseDTO = null;
		responseDTO = new ResponseDTO();
		
		ProductServiceDaoImpl pDaoImpl = null;
		pDaoImpl = new ProductServiceDaoImpl();
		
		List<Product> productList = pDaoImpl.getAllProducts();
		if(productList.size()>0) {
			responseDTO.setDataClass(productList.toString());
			responseDTO.setResponseCode(1);
			responseDTO.setResponseDescription("List of products");
		} else {
			responseDTO.setResponseCode(1);
			responseDTO.setResponseDescription("No records found");
		}
		
		
		return responseDTO;
	}

	@Override
	public ResponseDTO getProduct(int productKey) {
		// TODO Auto-generated method stub
		
		ResponseDTO responseDTO = null;
		responseDTO = new ResponseDTO();
		
		ProductServiceDaoImpl pDaoImpl = null;
		pDaoImpl = new ProductServiceDaoImpl();
		
		Product product = pDaoImpl.getProduct(productKey);
		if(product.getProductId().isEmpty()) {
	
			responseDTO.setResponseCode(1);
			responseDTO.setResponseDescription("No records found");
			
		} else {
			
			responseDTO.setDataClass(product.toString());
			responseDTO.setResponseCode(1);
			responseDTO.setResponseDescription("Product");
						
		}
		
		
		return responseDTO;
	}

	@Override
	public ResponseDTO deleteProduct(int productKey) {
		// TODO Auto-generated method stub
		
		ResponseDTO responseDTO = null;
		responseDTO = new ResponseDTO();
		
		ProductServiceDaoImpl daoImpl = null;
		daoImpl = new ProductServiceDaoImpl();
		
		Boolean deBoolean = false;
		deBoolean = daoImpl.deleteProduct(productKey);
		
		responseDTO.setDataClass(null);
		if(deBoolean.valueOf(true)) {
			responseDTO.setResponseCode(1);
			responseDTO.setResponseDescription(" Product deleted ");
		} else {
			responseDTO.setResponseCode(0);
			responseDTO.setResponseDescription(" Product not deleted ");
		}
		
		return responseDTO; 
	}

}
