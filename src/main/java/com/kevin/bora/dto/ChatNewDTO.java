package com.kevin.bora.dto;

import java.io.Serializable;

public class ChatNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer login1;
	private Integer login2;
	private Integer login3;
	private Integer login4;
	private Integer login5;
	private Integer login6;

	public ChatNewDTO() {
	}

	public ChatNewDTO(Integer login1, Integer login2, Integer login3, Integer login4, Integer login5, Integer login6) {
		super();
		this.login1 = login1;
		this.login2 = login2;
		this.login3 = login3;
		this.login4 = login4;
		this.login5 = login5;
		this.login6 = login6;
	}

	public Integer getLogin1() {
		return login1;
	}

	public void setLogin1(Integer login1) {
		this.login1 = login1;
	}

	public Integer getLogin2() {
		return login2;
	}

	public void setLogin2(Integer login2) {
		this.login2 = login2;
	}

	public Integer getLogin3() {
		return login3;
	}

	public void setLogin3(Integer login3) {
		this.login3 = login3;
	}

	public Integer getLogin4() {
		return login4;
	}

	public void setLogin4(Integer login4) {
		this.login4 = login4;
	}

	public Integer getLogin5() {
		return login5;
	}

	public void setLogin5(Integer login5) {
		this.login5 = login5;
	}

	public Integer getLogin6() {
		return login6;
	}

	public void setLogin6(Integer login6) {
		this.login6 = login6;
	}
}