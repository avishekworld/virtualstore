package edu.mum.product.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.mum.review.domain.Review;

@Entity
@Table(name="PRODUCT_TABLE")
public class Product {
	
	@Id @GeneratedValue
	@Column(name="PRODUCT_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PRICE")
	private Float price;
	
	@OneToOne( mappedBy="product")
	private ProductInventory productInventory;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CATAGORY_ID")
	private Catagory catagory;// = new ArrayList<Catagory>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
	private List<Review> reviews = new ArrayList<Review>();
	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public ProductInventory getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(ProductInventory productInventory) {
		this.productInventory = productInventory;
	}

}
