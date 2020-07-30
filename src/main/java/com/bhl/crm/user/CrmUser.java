package com.bhl.crm.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class CrmUser {
	
	@NotNull
	@Size(min=5)
	private String userName;
	
	@NotNull
	@Size(min=2)
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CrmUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	/*
	 * @NotNull
	 * 
	 * @Size(min = 5) private String firstName;
	 * 
	 * @NotNull
	 * 
	 * @Size(min = 5) private String lastName;
	 * 
	 * @NotNull
	 * 
	 * @Size(min = 5, message = "is required") private String email;
	 */

	
	}
