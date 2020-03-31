package com.kevin.bora.dto;

import java.io.Serializable;

import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.LoginEvent;

public class EventNewDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name; 
	private String date;  
	private Category category; 
	private LoginEvent loginEvent;
	private String email;
	
	public EventNewDTO() {
	}

	public EventNewDTO(Integer id, String name, String date, Category category, LoginEvent loginEvent, String email) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.category = category;
		this.loginEvent = loginEvent;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LoginEvent getLoginEvent() {
		return loginEvent;
	}

	public void setLoginEvent(LoginEvent loginEvent) {
		this.loginEvent = loginEvent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}