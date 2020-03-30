package com.kevin.bora.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Event")
public class MPEvent extends MainPage{
	private static final long serialVersionUID = 1L;

	@OneToOne(mappedBy="mPEvent", cascade=CascadeType.ALL)
	private Event event;

	public MPEvent() {
	}

	public MPEvent(Integer id, String nickName, String password) {
		super(id, nickName, password);
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	
	}
}