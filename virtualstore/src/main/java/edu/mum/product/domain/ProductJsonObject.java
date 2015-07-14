package edu.mum.product.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class ProductJsonObject implements Serializable{

	//@Id
	private long productId;
	private String productName;
	private float productPrice;
	private int productQuantity;
	private String productDefaultImage;
	
	
	public ProductJsonObject() {
		// TODO Auto-generated constructor stub
	}


	public ProductJsonObject(long productId, String productName,
			float productPrice, int productQuantity, String productDefaultImage) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productDefaultImage = productDefaultImage;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public float getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public String getProductDefaultImage() {
		return productDefaultImage;
	}


	public void setProductDefaultImage(String productDefaultImage) {
		this.productDefaultImage = productDefaultImage;
	}
	
	
	
	

}
