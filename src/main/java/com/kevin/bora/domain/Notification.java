package com.kevin.bora.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Notification implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	private String title;
	private String text;
	private boolean invitation;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Event event;

	public Notification() {
	}

	public Notification(Integer id, String title, String text, boolean invitation, Event event) {
		super();
		this.id = id;
		this.date = new java.util.Date(System.currentTimeMillis());
		this.title = title;
		this.text = text;
		this.invitation = invitation;
		this.event = event;
	}
	
	public Notification(Integer id, String title, String text, boolean invitation, User user) {
		super();
		this.id = id;
		this.date = new java.util.Date(System.currentTimeMillis());
		this.title = title;
		this.text = text;
		this.invitation = invitation;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isInvitation() {
		return invitation;
	}

	public void setInvitation(boolean invitation) {
		this.invitation = invitation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
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
		Notification other = (Notification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 }