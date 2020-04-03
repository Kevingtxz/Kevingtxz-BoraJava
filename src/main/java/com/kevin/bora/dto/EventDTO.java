package com.kevin.bora.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.kevin.bora.domain.Event;

public class EventDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=50, message="O tamanho deve ser entre 5 e 30 caracteres")
	private String nickName;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=6, max=6, message="O tamanho deve ser 6 caracteres")
	private String date;
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer categoryId;
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer neighborhoodId;
	@NotEmpty(message="Preenchimento obrigatório")
	private String password;
	private Integer cityId;

	public EventDTO() {
	}

	public EventDTO(Event event) {
		super();
		this.id = event.getId();
		this.nickName = event.getNickName();
		this.date = event.getDate();
		this.categoryId = event.getCategory().getId();
		this.neighborhoodId = event.getNeighborhood().getId();
		this.cityId = event.getNeighborhood().getId();
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getInteger() {
		return cityId;
	}

	public void setInteger(Integer cityId) {
		this.cityId = cityId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNeighborhoodId() {
		return neighborhoodId;
	}

	public void setNeighborhoodId(Integer neighborhoodId) {
		this.neighborhoodId = neighborhoodId;
	}
}