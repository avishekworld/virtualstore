package edu.mum.product.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERLINE_TABLE")
public class OrderLine {

	@Id @GeneratedValue
	@Column(name="ORDERLINE_ID")
	private Long id;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;
	
	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public OrderLine() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
