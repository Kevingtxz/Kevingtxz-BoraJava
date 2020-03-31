package com.kevin.bora.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EventUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@OneToOne
	private LoginEvent loginEvent;
	
	@JsonIgnore
	@OneToMany(mappedBy="eventUsers")
	private List<EventUser> EventUserList = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne
	private Chat chatEvent;
	
	public EventUsers() {
	}

	public EventUsers(Integer id, LoginEvent loginEvent, Chat chatEvent) {
		super();
		this.id = id;
		this.loginEvent = loginEvent;
		this.chatEvent = chatEvent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public LoginEvent getLoginEvent() {
		return loginEvent;
	}

	public void setLoginEvent(LoginEvent loginEvent) {
		this.loginEvent = loginEvent;
	}

	public List<EventUser> getEventUserList() {
		return EventUserList;
	}

	public void setEventUserList(List<EventUser> eventUserList) {
		EventUserList = eventUserList;
	}

	public Chat getChatEvent() {
		return chatEvent;
	}

	public void setChatEvent(Chat chatEvent) {
		this.chatEvent = chatEvent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventUsers other = (EventUsers) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}