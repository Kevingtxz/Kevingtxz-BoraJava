package com.kevin.bora.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class MessageNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento obrigatório")
	private Integer sender_id;
	@NotEmpty(message="Preenchimento obrigatório")
	private String msg;
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer chat_id;
	
	public MessageNewDTO() {
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