package edu.mum.customer.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_PROFILE_TABLE")
public class UserProfile {
	
	@Id
	@Column(name="USER_PROFILE_ID")
	private Long id;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="lineOne", column=@Column(name="SHIPPING_LINE_ONE")),
		@AttributeOverride(name="lineTwo", column=@Column(name="SHIPPING_LINE_TWO")),
		@AttributeOverride(name="state", column=@Column(name="SHIPPING_STATE")),
		@AttributeOverride(name="zipCode", column=@Column(name="SHIPPING_ZIP_CODE"))
	})
	private Address shippingAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="lineOne", column=@Column(name="BILLING_LINE_ONE")),
		@AttributeOverride(name="lineTwo", column=@Column(name="BILLING_LINE_TWO")),
		@AttributeOverride(name="state", column=@Column(name="BILLING_STATE")),
		@AttributeOverride(name="zipCode", column=@Column(name="BILLING_ZIP_CODE"))
	})	
	private Address billingAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	

}
