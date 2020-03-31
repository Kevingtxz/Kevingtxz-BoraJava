package com.kevin.bora.dto;

import java.io.Serializable;

import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.Event;

public class EventDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private String name;
	private String date;
	private Category category;
	private City address;
	private String email;

	public EventDTO() {
	}
	
	public EventDTO(Event event) {
		this.id = event.getId();
		this.name = event.getName();
		this.date = event.getDate();
		this.address = event.getCity();
		this.category = event.getCategory();
		this.email = event.getEmail();
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

	public City getAddress() {
		return address;
	}

	public void setAddress(City address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}