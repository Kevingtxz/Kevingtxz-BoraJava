package com.kevin.bora.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("User")
public class MPUser extends MainPage {
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="mPUser", cascade=CascadeType.ALL)
	private User user;
	
	public MPUser() {
	}
	
	public MPUser(Integer id, String nickName, String password) {
		super(id, nickName, password);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	
	}
}