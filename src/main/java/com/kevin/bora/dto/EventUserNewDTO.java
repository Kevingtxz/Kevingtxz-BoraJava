package com.kevin.bora.dto;

import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.LoginUser;
import com.kevin.bora.domain.enums.Participation;
import com.kevin.bora.domain.enums.Permission;

public class EventUserNewDTO {

	private Integer id;
	private Permission permission;
	private LoginUser loginUser;
	private EventUsers eventUsers;
	private Participation participation;
	
	public EventUserNewDTO() {
	}

	public EventUserNewDTO(Permission permission, LoginUser loginUser, EventUsers eventUsers, Participation participation) {
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

	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
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