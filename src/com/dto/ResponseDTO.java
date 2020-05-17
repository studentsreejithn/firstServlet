package com.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseDTO {

	private int responseCode;
	private String responseDescription;
	private String dataClass;
	
	
	
	public ResponseDTO() {
		super();
	}

	public ResponseDTO(int responseCode, String responseDescription, String dataClass) {
		super();
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
		this.dataClass = dataClass;
	}

	@XmlElement
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	@XmlElement
	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	@XmlElement
	public String getDataClass() {
		return dataClass;
	}

	public void setDataClass(String dataClass) {
		this.dataClass = dataClass;
	}

	@Override
	public String toString() {
		return "ResponseDTO [responseCode=" + responseCode + ", responseDescription=" + responseDescription
				+ ", dataClass=" + dataClass + "]";
	}
	
	
	
	
}
