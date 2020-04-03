package com.kevin.bora.dto;

import java.io.Serializable;

public class ChatDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer userId1;
	
	public ChatDTO() {
	}

	public ChatDTO(Integer userId1) {
		super();
		this.userId1 = userId1;
	}

	public Integer getUserId1() {
		return userId1;
	}

	public void setUserId1(Integer userId1) {
		this.userId1 = userId1;
	}
}