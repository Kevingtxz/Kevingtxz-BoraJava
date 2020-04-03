package com.kevin.bora.dto;

import java.io.Serializable;

public class ChatNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer userId1;
	private Integer userId2;
	private Integer userId3;
	private Integer userId4;
	private Integer userId5;
	
	public ChatNewDTO() {
	}

	public ChatNewDTO(Integer userId1, Integer userId2, Integer userId3, Integer userId4, Integer userId5) {
		super();
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.userId3 = userId3;
		this.userId4 = userId4;
		this.userId5 = userId5;
	}

	public Integer getUserId1() {
		return userId1;
	}

	public void setUserId1(Integer userId1) {
		this.userId1 = userId1;
	}

	public Integer getUserId2() {
		return userId2;
	}

	public void setUserId2(Integer userId2) {
		this.userId2 = userId2;
	}

	public Integer getUserId3() {
		return userId3;
	}

	public void setUserId3(Integer userId3) {
		this.userId3 = userId3;
	}

	public Integer getUserId4() {
		return userId4;
	}

	public void setUserId4(Integer userId4) {
		this.userId4 = userId4;
	}

	public Integer getUserId5() {
		return userId5;
	}

	public void setUserId5(Integer userId5) {
		this.userId5 = userId5;
	}
}