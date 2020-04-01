package com.kevin.bora.dto;

import java.io.Serializable;

public class ChatNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer user1;
	private Integer user2;
	private Integer user3;
	private Integer user4;
	private Integer user5;
	
	public ChatNewDTO() {
	}

	public ChatNewDTO(Integer user1, Integer user2, Integer user3, Integer user4, Integer user5) {
		super();
		this.user1 = user1;
		this.user2 = user2;
		this.user3 = user3;
		this.user4 = user4;
		this.user5 = user5;
	}

	public Integer getUserId1() {
		return user1;
	}

	public void setUserId1(Integer user1) {
		this.user1 = user1;
	}

	public Integer getUserId2() {
		return user2;
	}

	public void setUserId2(Integer user2) {
		this.user2 = user2;
	}

	public Integer getUserId3() {
		return user3;
	}

	public void setUserId3(Integer user3) {
		this.user3 = user3;
	}

	public Integer getUserId4() {
		return user4;
	}

	public void setUserId4(Integer user4) {
		this.user4 = user4;
	}

	public Integer getUserId5() {
		return user5;
	}

	public void setUserId5(Integer user5) {
		this.user5 = user5;
	}
}