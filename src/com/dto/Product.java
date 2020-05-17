package com.dto;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Product {

	private int productKey; 
	private String productId;
	private String productName;
	private long productPrice;
	private Date productExpiryDate;
	private Date productMfgDate;
	private String MfgLocation;
	private Boolean isAuthorisedSeller;
	
	public Product() {
		super();
	}

	
	
	public Product(int productKey, String productId, String productName, long productPrice, Date productExpiryDate,
			Date productMfgDate, String mfgLocation, Boolean isAuthorisedSeller) {
		super();
		this.productKey = productKey;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productExpiryDate = productExpiryDate;
		this.productMfgDate = productMfgDate;
		MfgLocation = mfgLocation;
		this.isAuthorisedSeller = isAuthorisedSeller;
	}



	public int getProductKey() {
		return productKey;
	}


	public void setProductKey(int productKey) {
		this.productKey = productKey;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(Date productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}

	public Date getProductMfgDate() {
		return productMfgDate;
	}

	public void setProductMfgDate(Date productMfgDate) {
		this.productMfgDate = productMfgDate;
	}

	public String getMfgLocation() {
		return MfgLocation;
	}

	public void setMfgLocation(String mfgLocation) {
		MfgLocation = mfgLocation;
	}

	public Boolean getIsAuthorisedSeller() {
		return isAuthorisedSeller;
	}

	public void setIsAuthorisedSeller(Boolean isAuthorisedSeller) {
		this.isAuthorisedSeller = isAuthorisedSeller;
	}



	@Override
	public String toString() {
		return "Product [productKey=" + productKey + ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productExpiryDate=" + productExpiryDate + ", productMfgDate="
				+ productMfgDate + ", MfgLocation=" + MfgLocation + ", isAuthorisedSeller=" + isAuthorisedSeller + "]";
	}
	
	
}
