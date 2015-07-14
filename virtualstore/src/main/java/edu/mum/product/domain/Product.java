package edu.mum.product.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@JoinTable(name="PRODUCT_DETAILS_TABLE", joinColumns=@JoinColumn(name="PRODUCT_ID"))
	@Column(name="DETAILS")
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> details = new ArrayList<String>();
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="product")
	private ProductInventory productInventory;

	@OneToOne
	@JoinColumn(name="CATAGORY_ID")
	private Catagory catagory;// = new ArrayList<Catagory>();

	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
	private List<Review> reviews = new ArrayList<Review>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
	private List<ProductMedia> productMedias = new ArrayList<ProductMedia>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Catagory getCatagory() {
		return catagory;
	}
	
	public List<String> getDetails() {
		return details;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getPrice() {
		return price;
	}

	public ProductInventory getProductInventory() {
		return productInventory;
	}

	public List<ProductMedia> getProductMedias() {
		return productMedias;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setProductInventory(ProductInventory productInventory) {
		this.productInventory = productInventory;
	}

	public void setProductMedias(List<ProductMedia> productMedias) {
		this.productMedias = productMedias;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
