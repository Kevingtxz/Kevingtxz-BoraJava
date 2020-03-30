package com.kevin.bora.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.kevin.bora.domain.enums.Participation;
import com.kevin.bora.domain.enums.Permission;

@Entity
public class EventUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer permission;
	private Integer participation;
	
	@OneToOne
	private MPUser mPUser;
	
	@OneToOne
	private EventUsers eventUsers;
	
	public EventUser() {
		
	}

	public EventUser(Integer id, Permission permission, Participation participation, MPUser mPUser) {
		super();
		this.id = id;
		this.permission = (permission == null) ? Permission.USER.getCod() : permission.getCod();
		this.participation = (participation == null) ? Participation.NOTHING.getCod() : participation.getCod();
		this.mPUser = mPUser;
	}
	
	public EventUser(Integer id, MPUser mPUser, EventUsers eventUsers) {
		super();
		this.id = id;
		this.permission = Permission.USER.getCod();
		this.participation = Participation.NOTHING.getCod();
		this.mPUser = mPUser;
		this.eventUsers = eventUsers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public Integer getParticipation() {
		return participation;
	}

	public void setParticipation(Integer participation) {
		this.participation = participation;
	}

	public MPUser getmPUser() {
		return mPUser;
	}

	public void setmPUser(MPUser mPUser) {
		this.mPUser = mPUser;
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
		EventUser other = (EventUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}