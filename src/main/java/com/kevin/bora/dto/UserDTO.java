package com.kevin.bora.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.kevin.bora.domain.Address;
import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.User;
import com.kevin.bora.services.validation.UserUpdate;

@UserUpdate
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@Length(min=5, max=50, message="O tamnho deve ser entre 5 e 30 caracteres")
	@Email(message="Email inválido")
	private String email;
	private Integer permission; 
	private Address address;
	private EventUsers eventUsers;
	private String gender;

	public UserDTO() {
	}

	public UserDTO(User obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.setGender(obj.getGender());
		this.permission = obj.getPermission();
		this.address = obj.getAddress();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EventUsers getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(EventUsers eventUsers) {
		this.eventUsers = eventUsers;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}