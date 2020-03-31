package com.kevin.bora.dto;

import com.kevin.bora.domain.Chat;

public class MessageNewDTO {

	private Integer sender_id;
	private String msg;
	private Chat chat;
	
	public MessageNewDTO() {
	}

	public MessageNewDTO(Integer sender_id, String msg, Chat chat) {
		super();
		this.sender_id = sender_id;
		this.msg = msg;
		this.chat = chat;
	}

	public Integer getSender_id() {
		return sender_id;
	}

	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}
}