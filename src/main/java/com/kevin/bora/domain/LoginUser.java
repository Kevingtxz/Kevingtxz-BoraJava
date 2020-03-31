package com.kevin.bora.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("User")
public class LoginUser extends Login {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToOne(mappedBy="mPUser", cascade=CascadeType.ALL)
	private User user;
	
	public LoginUser() {
	}
	
	public LoginUser(Integer id, String nickName, String password) {
		super(id, nickName, password);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	
	}
}