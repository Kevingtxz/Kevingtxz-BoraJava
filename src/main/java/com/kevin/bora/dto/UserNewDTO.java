package com.kevin.bora.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Length(min=5, max=50, message="O tamnho deve ser entre 5 e 50 caracteres")
	private String nickName;
	
	@Length(min=5, max=20, message="O tamnho deve ser entre 5 e 20 caracteres")
	@NotEmpty
	private String name;
	
	@Length(min=5, max=50, message="O tamnho deve ser entre 5 e 50 caracteres")
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	@Length(min=6, max=6, message="A data não está como o esperado")
	private String birth;
	
	@NotEmpty
	@Length(min=5, max=50, message="O tamnho deve ser entre 5 e 30 caracteres")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty
	@Length(min=8, max=255, message="O tamnho deve ser entre 8 e 255 caracteres")
	private String password;
	
	@Length(max=1, message="O tamnho deve ser entre 0 e 1 caracteres")
	private String gender;
	
	private Integer neighborhoodId;
	
	private Integer permissionId;
	
	public UserNewDTO() {
	}

	public UserNewDTO(
			@NotEmpty @Length(min = 5, max = 50, message = "O tamnho deve ser entre 5 e 50 caracteres") String nickName,
			@Length(min = 5, max = 20, message = "O tamnho deve ser entre 5 e 20 caracteres") @NotEmpty String name,
			@Length(min = 5, max = 50, message = "O tamnho deve ser entre 5 e 50 caracteres") @NotEmpty String lastName,
			@NotEmpty @Length(min = 6, max = 6, message = "A data não está como o esperado") String birth,
			@NotEmpty @Length(min = 5, max = 50, message = "O tamnho deve ser entre 5 e 30 caracteres") @Email(message = "Email inválido") String email,
			@NotEmpty @Length(min = 8, max = 255, message = "O tamnho deve ser entre 8 e 255 caracteres") String password,
			@Length(max = 1, message = "O tamnho deve ser entre 0 e 1 caracteres") String gender,
			@NotEmpty Integer neighborhoodId, Integer permissionId) {
		super();
		this.nickName = nickName;
		this.name = name;
		this.lastName = lastName;
		this.birth = birth;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.neighborhoodId = neighborhoodId;
		this.permissionId = permissionId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getNeighborhoodId() {
		return neighborhoodId;
	}

	public void setNeighborhoodId(Integer neighborhoodId) {
		this.neighborhoodId = neighborhoodId;
	}
}