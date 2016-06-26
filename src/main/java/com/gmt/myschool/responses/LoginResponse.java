package com.gmt.myschool.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmt.myschool.dao.UserDao;

public class LoginResponse extends MessageResponse{
	
	@JsonProperty
	private UserDao user = null;

	public LoginResponse() {
		super();
		this.user = null;
	}
	
	public LoginResponse(UserDao user) {
		super();
		this.user = user;
	}
	
	public UserDao getUser() {
		return user;
	}

	public void setUser(UserDao user) {
		this.user = user;
	}
	
	

}
