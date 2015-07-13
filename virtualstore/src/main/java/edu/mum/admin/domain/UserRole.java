package edu.mum.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE_TABLE")
public class UserRole {
	
	@Id @GeneratedValue
	@Column(name="USER_ROLE_ID")
	private Long id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="USER_ROLE")
	private String userrole;
	

	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}
	
	

	public UserRole(String username, String userrole) {
		this.username = username;
		this.userrole = userrole;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	
	

}
