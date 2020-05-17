package com.adaptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.ProductServiceBL;
import com.bl.ProductServiceBLImpl;
import com.dto.Product;
import com.dto.ResponseDTO;
import com.sun.jndi.toolkit.url.Uri;

import util.JsonConverter;
import util.XmlConverter;

public class ProductAdaptor extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		
	
		ProductServiceBLImpl blImpl = null;		
		ResponseDTO responseDTO = null;
		
		ServletOutputStream servletOutputStream = null;
		InputStreamReader in = null;
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = null;
		
		String data = "";
		String requestString = "";
		String responseString = "";
		
		try {
			
			blImpl = new ProductServiceBLImpl();
			in = new InputStreamReader(httpServletRequest.getInputStream());
			bufferedReader = new BufferedReader(in);
			stringBuffer = new StringBuffer();
			
			while((data=bufferedReader.readLine())!=null) {
				stringBuffer.append(data);
			}
			
			requestString = stringBuffer.toString();
			
			Product product = null;
			
			if(requestString.isEmpty()) {
				
				responseDTO = new ResponseDTO();
				responseDTO.setResponseCode(0);
				responseDTO.setResponseDescription("Invalid data");
				
			} else {
				
				if(httpServletRequest.getContentType().equalsIgnoreCase("application/json")) {
					product = (Product) JsonConverter.jsonToObject(requestString, Product.class);
				} else {
					product = (Product) XmlConverter.xmltoobject(requestString, Product.class);
				}
				
				switch(httpServletRequest.getServletPath()) {
				case "/createProduct":
					responseDTO = blImpl.createProduct(product);
					break;
				case "/updateProduct":
					responseDTO = blImpl.updateProduct(product); 
					break;
				}
								
			}
			

			if(httpServletRequest.getContentType()!="application/json") {
				
				responseString = XmlConverter.objecttoxml(responseDTO, responseDTO.getClass());
				httpServletResponse.setContentType("application/xml");
				
			} else {
				
				responseString = JsonConverter.objectToJson(responseDTO);
				httpServletResponse.setContentType("application/json");
				
			}
			
			servletOutputStream = httpServletResponse.getOutputStream();
			servletOutputStream.write(responseString.getBytes());
			
			
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		
		
		
		ProductServiceBLImpl blImpl = null;
		ResponseDTO responseDTO = null;
		
		ServletOutputStream outputStream = null;
		String ResponseString = null;
		
		String productKey = null;
		
		try {
			
			switch(httpServletRequest.getServletPath()) {
			case "/listProduct":
				
				blImpl = new ProductServiceBLImpl();
				responseDTO = blImpl.getAllProducts();
				
				break;
			case "/getProduct":
				
				productKey = httpServletRequest.getParameter("productKey");
				blImpl = new ProductServiceBLImpl();
				responseDTO = blImpl.getProduct(Integer.valueOf(productKey));
				
				break;
			case "/deleteProduct":
				
				productKey = httpServletRequest.getParameter("productKey");
				blImpl = new ProductServiceBLImpl();
				responseDTO = blImpl.deleteProduct(Integer.valueOf(productKey));
				
				break;
			}
			
			
			if(httpServletRequest.getContentType()!="application/json") {
				
				ResponseString = XmlConverter.objecttoxml(responseDTO, responseDTO.getClass());
				httpServletResponse.setContentType("application/xml");
				
			} else {
				
				ResponseString = JsonConverter.objectToJson(responseDTO);
				httpServletResponse.setContentType("application/json");
			}
			
			
			
			
			outputStream = httpServletResponse.getOutputStream();
			outputStream.write(ResponseString.getBytes());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
