package com.kevin.bora.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.User;
	
public class EventUserNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer permissionId;
	@NotEmpty(message="Preenchimento obrigatório")
	private User loginUser;
	@NotEmpty(message="Preenchimento obrigatório")
	private EventUsers eventUsers;
	private Integer participationId;

	public EventUserNewDTO() {
	}

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
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

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getParticipationId() {
		return participationId;
	}

	public void setParticipationId(Integer participationId) {
		this.participationId = participationId;
	}
}