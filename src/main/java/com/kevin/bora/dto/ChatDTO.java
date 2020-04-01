package com.kevin.bora.dto;

import java.io.Serializable;

public class ChatDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer user1;
	private boolean isPost;
	
	public ChatDTO() {
	}

	public ChatDTO(Integer user1, boolean isPost) {
		super();
		this.user1 = user1;
		this.isPost = isPost;
	}

	public Integer getUserId1() {
		return user1;
	}

	public void setUserId1(Integer user1) {
		this.user1 = user1;
	}

	public boolean isPost() {
		return isPost;
	}

	public void setPost(boolean isPost) {
		this.isPost = isPost;
	}
}