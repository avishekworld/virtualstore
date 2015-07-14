package edu.mum.product.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_INVENTORY_TABLE")
public class ProductInventory {
	
	@Id @GeneratedValue
	@Column(name="PRODUCT_INVENTORY_ID")
	private Long id;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	
	
	public ProductInventory(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public ProductInventory() {
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
	
	
}
