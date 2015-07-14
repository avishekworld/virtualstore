package edu.mum.admin.domain;

import java.io.Serializable;

public class PaymentResponse implements Serializable{
	
	String paymentSucess;
	String message;
	long paymentId;

	
	public PaymentResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentResponse(String paymentSucess, String message, long paymentId) {
		this.paymentSucess = paymentSucess;
		this.message = message;
		this.paymentId = paymentId;
	}

	public String getPaymentSucess() {
		return paymentSucess;
	}
	public void setPaymentSucess(String paymentSucess) {
		this.paymentSucess = paymentSucess;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
