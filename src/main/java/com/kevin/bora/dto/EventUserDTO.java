package com.kevin.bora.dto;

public class EventUserDTO {

	private Integer permissionId;
	private Integer participationId;
	
	public EventUserDTO() {
	}
	
	public Integer getPermission() {
		return permissionId;
	}

	public void setPermission(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getParticipation() {
		return participationId;
	}

	public void setParticipation(Integer participationId) {
		this.participationId = participationId;
	}
}