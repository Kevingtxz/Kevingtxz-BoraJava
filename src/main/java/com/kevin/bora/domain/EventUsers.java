package com.kevin.bora.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EventUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@OneToOne(mappedBy="eventUsers")
	private Event event;
	
	@JsonIgnore
	@OneToMany(mappedBy="eventUsers", cascade=CascadeType.ALL)
	private List<EventUser> EventUserList = new ArrayList<>();

	@JsonIgnore
	@OneToOne
	private Chat chat;
	
	public EventUsers() {
	}

	public EventUsers(Integer id, Event event, Chat chat) {
		super();
		this.id = id;
		this.chat = chat;
		this.event = event;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<EventUser> getEventUserList() {
		return EventUserList;
	}

	public void setEventUserList(List<EventUser> eventUserList) {
		EventUserList = eventUserList;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChatEvent(Chat chat) {
		this.chat= chat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventUsers other = (EventUsers) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}