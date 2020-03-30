package com.kevin.bora.dto;

import com.kevin.bora.domain.enums.Participation;

public class EventUserDTO {

	private Integer permission;
	private Integer participation;
	
	public EventUserDTO() {
	}

	public EventUserDTO(Participation permission, Participation participation) {
		super();
		this.permission = permission.getCod();
		this.participation = participation.getCod();
	}
	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public Integer getParticipation() {
		return participation;
	}

	public void setParticipation(Integer participation) {
		this.participation = participation;
	}
}