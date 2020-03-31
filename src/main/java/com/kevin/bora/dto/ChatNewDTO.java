package com.kevin.bora.dto;

import java.io.Serializable;

import com.kevin.bora.domain.Login;

public class ChatNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Login login1;
	private Login login2;
	private Login login3;
	private Login login4;
	private Login login5;
	public ChatNewDTO() {
	}

	public ChatNewDTO(Login login1, Login login2, Login login3, Login login4, Login login5) {
		super();
		this.login1 = login1;
		this.login2 = login2;
		this.login3 = login3;
		this.login4 = login4;
		this.login5 = login5;
	}

	public Login getLogin1() {
		return login1;
	}

	public void setLogin1(Login login1) {
		this.login1 = login1;
	}

	public Login getLogin2() {
		return login2;
	}

	public void setLogin2(Login login2) {
		this.login2 = login2;
	}

	public Login getLogin3() {
		return login3;
	}

	public void setLogin3(Login login3) {
		this.login3 = login3;
	}

	public Login getLogin4() {
		return login4;
	}

	public void setLogin4(Login login4) {
		this.login4 = login4;
	}

	public Login getLogin5() {
		return login5;
	}

	public void setLogin5(Login login5) {
		this.login5 = login5;
	}
}