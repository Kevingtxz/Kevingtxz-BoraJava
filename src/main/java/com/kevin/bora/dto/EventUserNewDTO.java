package com.kevin.bora.dto;

import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.LoginUser;
import com.kevin.bora.domain.enums.Participation;

public class EventUserNewDTO {

	private Integer id;
	private Integer permission;
	private LoginUser loginUser;
	private EventUsers eventUsers;
	private Integer participation;
	
	public EventUserNewDTO() {
	}

	public EventUserNewDTO(Participation permission, LoginUser loginUser, EventUsers eventUsers, Participation participation) {
		super();
		this.id = null;
		this.permission = permission.getCod();
		this.loginUser = loginUser;
		this.eventUsers = eventUsers;
		this.participation = participation.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
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

	public Integer getParticipation() {
		return participation;
	}

	public void setParticipation(Integer participation) {
		this.participation = participation;
	}
}