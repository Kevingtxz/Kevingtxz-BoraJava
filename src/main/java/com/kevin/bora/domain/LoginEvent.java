package com.kevin.bora.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Event")
public class LoginEvent extends Login{
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="loginEvent", cascade=CascadeType.ALL)
	private Event event;
	
	@JsonIgnore
	@OneToOne(mappedBy="loginEvent", cascade=CascadeType.ALL)
	private EventUsers eventUsers;

	public LoginEvent() {
	}

	public LoginEvent(Integer id, String nickName, String password) {
		super(id, nickName, password);
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	
	}
}