package com.kevin.bora.dto;

public class LoginDTO {
	
	private String nickName;
	private String password;
	private String notes;

	public LoginDTO() {
	}

	public LoginDTO(String nickName, String password, String notes) {
		super();
		this.nickName = nickName;
		this.password = password;
		this.notes = notes;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}