package com.kevin.bora.dto;

import java.io.Serializable;

public class CityNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer state_id;
	private String name;
	
	public CityNewDTO() {
	}

	public CityNewDTO(Integer state_id, String name) {
		super();
		this.state_id = state_id;
		this.name = name;
		this.id = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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