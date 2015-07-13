package edu.mum.product.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATAGORY_TABLE")
public class Catagory {
	
	@Id @GeneratedValue
	@Column(name="CATAGORY_ID")
	private Long id;
	
	@Column(name="CATAGORY_NAME")
	private String catagoryName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getCatagoryName() {
		return catagoryName;
	}

	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}

	public Catagory() {
		// TODO Auto-generated constructor stub
	}

}
