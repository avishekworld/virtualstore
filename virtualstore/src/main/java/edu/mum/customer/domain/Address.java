package edu.mum.customer.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="LINE_ONE")
	private String lineOne; 
	
	@Column(name="LINE_TWO")
	private String lineTwo;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP_CODE")
	private long zipCode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getLineOne() {
		return lineOne;
	}

	public String getLineTwo() {
		return lineTwo;
	}

	public String getState() {
		return state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
