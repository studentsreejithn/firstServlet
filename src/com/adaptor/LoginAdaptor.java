package com.adaptor;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Login;
import com.dto.ResponseDTO;

import util.JsonConverter;

public class LoginAdaptor extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException,IOException {
		
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = null;		
		String data = null;
		ResponseDTO responseDTO = null;
		
		String requestString = null;
		String responseString = null;
		
		InputStreamReader in = null;
		ServletOutputStream servletOutputStream = null;
		
		try {
			
			in = new InputStreamReader(httpServletRequest.getInputStream()); 
			bufferedReader = new BufferedReader(in); 
			stringBuffer = new StringBuffer();
			responseDTO = new ResponseDTO();
			
			while ((data = bufferedReader.readLine()) != null) {
				stringBuffer.append(data);
			}
			
			requestString = stringBuffer.toString();
			
			Login login = null;
			login = (Login) JsonConverter.jsonToObject(requestString, Login.class); 
			
			if(login.getPassword().equalsIgnoreCase("password") && login.getUserName().equalsIgnoreCase("sreejith")) {
				
				responseDTO.setResponseCode(0);
				responseDTO.setResponseDescription("Successfull login");
				responseDTO.setDataClass(JsonConverter.objectToJson(login));
			} else {
				responseDTO.setResponseCode(0);
				responseDTO.setResponseDescription("Successfull failed");
			}
			
			
		} catch(Exception e) {
			//System.out.println(e);
			//System.out.println("Exception "+e.getMessage());
			
			responseDTO.setResponseCode(1);
			responseDTO.setResponseDescription(e.getMessage());
			
		}
				
		responseString = JsonConverter.objectToJson(responseDTO);
		httpServletResponse.setContentType("application/json");
		servletOutputStream = httpServletResponse.getOutputStream();
		servletOutputStream.write(responseString.getBytes()); 
		
	}
}
