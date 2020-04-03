package com.kevin.bora.dto;

import java.io.Serializable;

import com.sun.istack.NotNull;

public class ChatDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull()
	private Integer userId1;
	
	public ChatDTO() {
	}

	public Integer getUserId1() {
		return userId1;
	}

	public void setUserId1(Integer userId1) {
		this.userId1 = userId1;
	}
}