package edu.mum.product.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.mum.customer.domain.Address;
import edu.mum.customer.domain.PaymentInfo;
import edu.mum.customer.domain.User;

@Entity
@Table(name="ORDER_TABLE")
public class Order {

	@Id 
	@GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PAYMENT_ID")
	private PaymentInfo payment;
	
	@Embedded
	private Address address;
	
	@OneToMany( mappedBy="order")
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentInfo getPayment() {
		return payment;
	}

	public void setPayment(PaymentInfo payment) {
		this.payment = payment;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	

}
