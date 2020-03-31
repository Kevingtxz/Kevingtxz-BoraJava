package com.kevin.bora.dto;

import java.io.Serializable;

public class MessageNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer sender_id;
	private String msg;
	private Integer chat_id;
	
	public MessageNewDTO() {
	}

	public MessageNewDTO(Integer id, Integer sender_id, String msg, Integer chat_id) {
		super();
		this.id = id;
		this.sender_id = sender_id;
		this.msg = msg;
		this.chat_id = chat_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getChat_id() {
		return chat_id;
	}

	public void setChat_id(Integer chat_id) {
		this.chat_id = chat_id;
	}
}