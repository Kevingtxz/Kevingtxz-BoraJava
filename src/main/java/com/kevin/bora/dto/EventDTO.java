package com.kevin.bora.dto;

import java.io.Serializable;

import com.kevin.bora.domain.Address;
import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.Event;

public class EventDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	

	private Integer id;
	private String name;
	private String date;
	private Category category;
	private Address address;

	public EventDTO() {
	}
	
	public EventDTO(Event event) {
		this.id = event.getId();
		this.name = event.getName();
		this.date = event.getDate();
		this.address = event.getAddress();
		this.category = event.getCategory();
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}