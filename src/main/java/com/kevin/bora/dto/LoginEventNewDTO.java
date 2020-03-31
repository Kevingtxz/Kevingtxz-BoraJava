package com.kevin.bora.dto;

import javax.validation.constraints.NotEmpty;

import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Neighborhood;
import com.kevin.bora.domain.State;

public class LoginEventNewDTO {
	private String nickName;
	private String password;
	
	private String name; 
	private String date;  
	private String email;
	private Category category; 
	
	@NotEmpty
	private State state;
	@NotEmpty
	private City city;
	@NotEmpty
	private Neighborhood neighborhood;
	
	private String categoryName;
	
	
	public LoginEventNewDTO() {
	}

	public LoginEventNewDTO(String nickName, String password, @NotEmpty City city,
			Neighborhood neighborhood, String name, String date, Category category, City address, String email, String categoryName) {
		super();
		this.nickName = nickName;
		this.password = password;
		this.city = city;
		this.neighborhood = neighborhood;
		this.category = category;
		this.date = date;
		this.email = email;
		this.name = name;
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}
}