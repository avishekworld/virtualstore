package edu.mum.review.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.mum.customer.domain.User;
import edu.mum.product.domain.Product;

@Entity
@Table(name="REVIEW_TABLE")
public class Review {
	
	@Id @GeneratedValue
	@Column(name="REVIEW_ID")
	private Long id;
	
	@Column(name="COMMENT")
	private String comment;
	
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public String getComment() {
		return comment;
	}

	public Date getDate() {
		return date;
	}

	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public User getUser() {
		return user;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
