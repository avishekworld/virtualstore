package edu.mum.product.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTMEDIA_TABLE")
public class ProductMedia {

	@Id @GeneratedValue
	@Column(name="PRODUCTMEDIA_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name="URL")
	private String url;
	
	public ProductMedia() {
		// TODO Auto-generated constructor stub
	}

	public ProductMedia(Product product, String url) {
		this.product = product;
		this.url = url;
	}
	
	

}
