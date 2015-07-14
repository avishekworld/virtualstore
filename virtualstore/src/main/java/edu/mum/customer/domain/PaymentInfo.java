package edu.mum.customer.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="PAYMENT_TABLE")
public class PaymentInfo {
	
	@Id @GeneratedValue
	@Column(name="PAYMENT_ID")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="PAYMENT_TYPE")
	private PayType payType;
	
	@Column(name="PAYMENT_NAME")
	private String paymentName;
	
	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	@Column(name="PAYMENT_CARD_NUMBER")
	private String cardNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRY_DATE")
	private Date expireDate;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Embedded
	private Address paymentAddress;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getPaymentAddress() {
		return paymentAddress;
	}

	public void setPaymentAddress(Address paymentAddress) {
		this.paymentAddress = paymentAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	

	
}
