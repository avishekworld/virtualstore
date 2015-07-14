package edu.mum.customer.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import edu.mum.product.domain.Order;
import edu.mum.review.domain.Review;



@Entity
@Table(name="USER_TABLE")
public class User { 
	
	@Id @GeneratedValue
	@Column(name="USER_ID")
	private Long id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="USERPASSWORD")
	private String password;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<Order> orders = new ArrayList<Order>();


	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<PaymentInfo> paymentInfos = new ArrayList<PaymentInfo>();


	//@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private UserProfile userProfile;


	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<Review> reviews = new ArrayList<Review>();


	public User() {

	}


	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}


	public Long getId() {
		return id;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<PaymentInfo> getPaymentInfos() {
		return paymentInfos;
	}
	


	public List<Review> getReviews() {
		return reviews;
	}


	public String getUsername() {
		return username;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}
	
	


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
}
