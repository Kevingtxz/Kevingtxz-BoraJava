package com.kevin.bora.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CityNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer state_id;
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	
	public CityNewDTO() {
	}


	public Integer getState_id() {
		return state_id;
	}

	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}