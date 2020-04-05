package com.kevin.bora.dto;

import java.io.Serializable;

import com.sun.istack.NotNull;
	
public class EventUserNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer permissionId;
	@NotNull
	private Integer userId;
	@NotNull
	private Integer eventUsersId;
	private Integer participationId;

	public EventUserNewDTO() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEventUsersId() {
		return eventUsersId;
	}

	public void setEventUsersId(Integer eventUsersId) {
		this.eventUsersId = eventUsersId;
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