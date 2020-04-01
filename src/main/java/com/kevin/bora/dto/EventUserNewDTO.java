package com.kevin.bora.dto;

import java.io.Serializable;

import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.User;
import com.kevin.bora.domain.enums.Participation;
import com.kevin.bora.domain.enums.Permission;
	
public class EventUserNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Permission permission;
	private User loginUser;
	private EventUsers eventUsers;
	private Participation participation;

	public EventUserNewDTO() {
	}

	public EventUserNewDTO(Permission permission, User loginUser, EventUsers eventUsers,
			Participation participation) {
		super();
		this.id = null;
		this.permission = permission;
		this.loginUser = loginUser;
		this.eventUsers = eventUsers;
		this.participation = participation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public User getUser() {
		return loginUser;
	}

	public void setUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public EventUsers getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(EventUsers eventUsers) {
		this.eventUsers = eventUsers;
	}

	public Participation getParticipation() {
		return participation;
	}

	public void setParticipation(Participation participation) {
		this.participation = participation;
	}
}